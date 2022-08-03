package com.picolite.models.transfers;


import com.picolite.dao.ArticleDao;
import com.picolite.models.Comment;
import com.picolite.services.ArticleService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
public class CommentTransfer implements Serializable {

    @Autowired
    private ArticleDao articleDao;


    private Long id;

    private String username;

    private String content;

    private Long article_id;

    public Comment convert(ArticleService articleService)
    {
        Comment c = new Comment();
        c.setContent(content);
        c.setUsername(username);
        c.setId(id);
        c.setArticle(articleService.findById(article_id));
        return c;
    }
}
