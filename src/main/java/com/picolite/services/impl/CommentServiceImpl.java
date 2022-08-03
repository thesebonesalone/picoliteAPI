package com.picolite.services.impl;

import com.picolite.dao.CommentDao;
import com.picolite.models.Comment;
import com.picolite.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public Comment create(Comment object) {
        return this.commentDao.create(object);
    }

    @Override
    public void update(Comment object) {
        this.commentDao.update(object);
    }

    @Override
    public List<Comment> findAll() {
        return null;
    }

    @Override
    public Comment findById(Long aLong) {
        return this.commentDao.getById(aLong);
    }

    @Override
    public void delete(Long aLong) throws Exception {
        this.commentDao.delete(aLong);
    }
}
