package com.picolite.services;

import com.picolite.models.Comment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Component
@Transactional
public interface CommentService extends CRUDService<Comment, Long>{


}
