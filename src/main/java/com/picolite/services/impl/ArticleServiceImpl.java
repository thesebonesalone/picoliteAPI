package com.picolite.services.impl;

import com.picolite.dao.ArticleDao;
import com.picolite.models.Article;
import com.picolite.models.Comment;
import com.picolite.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    public void setArticleDao(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @Override
    public Article create(Article object) {
        return this.articleDao.create(object);
    }

    public List<Comment> getCommentsByArticle(Long id)
    {
        return this.articleDao.getAllCommentsWithArticleId(id);
    }

    @Override
    public void update(Article object) {
        this.articleDao.update(object);
    }

    @Override
    public List<Article> findAll() {
        return this.articleDao.findAll();
    }

    @Override
    public Article findById(Long aLong) {
        return this.articleDao.getById(aLong);
    }

    @Override
    public void delete(Long aLong) throws Exception {
        this.articleDao.delete(aLong);
    }
}
