package com.comments.service;

import com.comments.entity.Comments;
import com.comments.repository.CommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class CommentService extends CrudService<Comments, CommentRepository> {

    public CommentService(CommentRepository repository) {
        super(repository);
    }
}
