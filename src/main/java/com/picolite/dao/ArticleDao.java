package com.picolite.dao;

import com.picolite.models.Article;
import com.picolite.models.Comment;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ArticleDao extends CRUDDao<Article, Long> {

    List<Comment> getAllCommentsWithArticleId(Long articleId);

}
