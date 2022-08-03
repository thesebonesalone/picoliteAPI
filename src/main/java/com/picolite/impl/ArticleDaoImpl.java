package com.picolite.impl;

import com.picolite.dao.ArticleDao;
import com.picolite.models.Article;
import com.picolite.models.Comment;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Component
@Transactional
public class ArticleDaoImpl implements ArticleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Article create(Article object) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(object);
        return object;
    }

    @Override
    public void update(Article object) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(object);
    }

    //hql literally the most basic call
    @Override
    public List<Article> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Article> articleList = session.createQuery("from Article").list();
        for(Article a : articleList) {
            log.info("Article List::" + a);
        }
        return articleList;
    }

    //criteria
    @Override
    public Article getById(Long aLong) {
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Article> cr = cb.createQuery(Article.class);
        Root<Article> root = cr.from(Article.class);
        cr.where(cb.equal(root.get("id"), aLong));
        TypedQuery<Article> query = session.createQuery(cr);
        return query.getSingleResult();
    }

    @Override
    public void delete(Long aLong) throws Exception {
        Session session = this.sessionFactory.getCurrentSession();
        Article a = getById(aLong);
        if (a != null)
        {
            session.delete(a);
            log.info("Article deleted successfully");
        } else
        {
            throw new Exception("Article Not Found");
        }
    }


    @Override
    public List<Comment> getAllCommentsWithArticleId(Long articleId) {
        Article a = getById(articleId);
        return a.getComments();
    }
}
