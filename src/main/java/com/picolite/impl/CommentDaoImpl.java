package com.picolite.impl;


import com.picolite.dao.CommentDao;
import com.picolite.models.Comment;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Component
@Transactional
public class CommentDaoImpl implements CommentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory;}

    @Override
    public Comment create(Comment object) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(object);
        return object;
    }

    @Override
    public void update(Comment object) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(object);
    }

    @Override
    public List<Comment> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Comment>  commentList = session.createQuery("from Comment").list();
        for(Comment c : commentList) {
            log.info("Comment List:: " + c);
        }
        return commentList;
    }

    @Override
    public Comment getById(Long aLong) {
        Session session = this.sessionFactory.getCurrentSession();
        Comment c = (Comment)session.get(Comment.class, new Long(aLong));
        log.info("Fetched Comment with ID: " + aLong);
        return c;
    }

    @Override
    public void delete(Long aLong) throws Exception {
        Session session = this.sessionFactory.getCurrentSession();
        Comment c = getById(aLong);
        if (c != null)
        {
            session.delete(c);
            log.info("Comment deleted successfully");
        } else {
            throw new Exception("Comment not found");
        }
    }

}
