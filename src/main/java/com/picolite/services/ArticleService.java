package com.picolite.services;

import com.picolite.models.Article;
import com.picolite.models.Comment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Component
@Transactional
public interface ArticleService extends CRUDService<Article, Long> {

    public List<Comment> getCommentsByArticle(Long id);
}
