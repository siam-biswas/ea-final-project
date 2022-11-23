package com.comments.service;

import com.comments.entity.Comments;

import java.util.List;
import java.util.Optional;

public interface ICommentService {

    Optional<Comments> getCommentsById(long id);

    List<Comments> getAllComments();

    Comments AddComment(Comments comments);

    void DeleteComment(long id);

    Comments UpdateComment(Comments comments);
}
