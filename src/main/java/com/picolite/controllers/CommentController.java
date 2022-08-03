package com.picolite.controllers;

import com.picolite.models.Article;
import com.picolite.models.Comment;
import com.picolite.models.transfers.CommentTransfer;
import com.picolite.services.ArticleService;
import com.picolite.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private ArticleService articleService;

    @CrossOrigin
    @RequestMapping(value = "/comments/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Comment> getComment(@PathVariable("id") Long id)
    {
        Comment c = commentService.findById(id);
        if (c != null)
        {
            return new ResponseEntity<>(c, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/comments/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteComment(@PathVariable("id") Long id)
    {
        try {
            commentService.delete(id);
        } catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @CrossOrigin
    @RequestMapping(value="/comments/article/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<List<Comment>> getArticleComments(@PathVariable("id") Long id)
    {
        System.out.println("Loading comments for " + id);
        List<Comment> a = articleService.getCommentsByArticle(id);
        return new ResponseEntity<>(a, HttpStatus.OK);
    }
    @CrossOrigin
    @RequestMapping(value = "/comments", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<Comment> createOrUpdateComment(@RequestBody CommentTransfer c)
    {
        System.out.println(c.getContent());
        Comment comment = c.convert(articleService);
        if (comment.getId() == 0)
        {
            this.commentService.create(comment);
            return new ResponseEntity<>(comment, HttpStatus.CREATED);
        } else {
            this.commentService.update(comment);
            return new ResponseEntity<>(comment, HttpStatus.OK);
        }
    }
}
