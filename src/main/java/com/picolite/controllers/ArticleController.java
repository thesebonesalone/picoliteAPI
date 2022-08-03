package com.picolite.controllers;


import com.picolite.models.Article;
import com.picolite.models.ArticleContainer;
import com.picolite.services.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
public class ArticleController {


    @Autowired
    private ArticleService articleService;

    public ResponseEntity notFound(String message)
    {
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @RequestMapping(value = "/articles/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Article> getArticle(@PathVariable("id") Long articleId)
    {
      log.info("In Article Get for : " + articleId);
      Article a = articleService.findById(articleId);
      if (a != null)
      {
          return new ResponseEntity<>(a, HttpStatus.OK);
      } else {
          return notFound("Could not find article with that ID");
      }
    }

    @CrossOrigin
    @RequestMapping(value="/articles/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteArticle(@PathVariable("id") Long articleId)
    {
        log.info("Deleting Article: " + articleId);
        try {
            articleService.delete(articleId);
        } catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


    @CrossOrigin
    @RequestMapping(value = "/articles", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArticleContainer> getAllArticles()
    {
        log.info("Fetching All Articles");
        List<Article> articles = articleService.findAll();
        ArticleContainer ac = new ArticleContainer();
        ac.setArticles(articles);
        return new ResponseEntity<>(ac, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "/articles", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<Article> createOrUpdateArticle(@RequestBody Article a)
    {
        System.out.println(a.getContent());
        if (a.getId() == 0)
        {
            this.articleService.create(a);
            return new ResponseEntity<>(a, HttpStatus.CREATED);
        } else {
            this.articleService.update(a);
            return new ResponseEntity<>(a, HttpStatus.OK);
        }
    }

}
