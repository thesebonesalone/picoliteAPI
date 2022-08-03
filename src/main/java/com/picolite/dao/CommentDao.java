package com.picolite.dao;

import com.picolite.models.Comment;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface CommentDao extends CRUDDao<Comment, Long>{
}
