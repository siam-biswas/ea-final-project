package com.comments.controller;

import com.comments.entity.Comments;
import com.comments.service.CommentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController extends CrudController<Comments, CommentService> {

    public CommentController(CommentService service) {
        super(service);
    }
}
