package com.comments.service;

import com.comments.entity.Comments;
import com.comments.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class CommentService implements ICommentService {
    private final
    CommentRepository commentRepository;
    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Optional<Comments> getCommentsById(long id) {
        return commentRepository.findAllById(id);
    }

    @Override
    public List<Comments> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public Comments AddComment(Comments comments) {
       return commentRepository.save(comments);
    }

    @Override
    public void DeleteComment(long id) {
         commentRepository.deleteById(id);
    }

    @Override
    public Comments UpdateComment(Comments comments) {
       return commentRepository.save(comments);
    }
}
