package com.comments.controller;

import com.comments.client.UserClient;
import com.comments.dto.UserDTO;
import com.comments.entity.Comments;
import com.comments.service.CommentService;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;
    private final UserClient userClient;
    public CommentController(CommentService commentService, UserClient userClient) {
        this.commentService = commentService;
        this.userClient = userClient;

        }
   /* @GetMapping
    public ResponseEntity<List<Comments>>getAllComments() {

        var result = commentService.getAllComments().stream().map( value ->{
            var user =  userClient.get(value.getUserId());
            value.setUser(user);
            return value;
        }).toList();

        return ResponseEntity.ok(result);
    }*/
   /* @GetMapping("/{id}")
    public ResponseEntity<Comments> getCommentsById(@PathVariable Long id) {
        Optional<Comments> data = commentService.getCommentsById(id).map(value ->{
            var user =  userClient.get(value.getUserId());
            value.setUser(user);
            return value;
        });

        if (data.isPresent()) {
            return ResponseEntity.ok(data.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/

    @GetMapping("/{id}")
    public Comments getCommentsById(@PathVariable(value = "id") Long id) {
       Comments data = commentService.getCommentsById(id);
       UserDTO userDTO  =userClient.get(data.getUserId());
       data.setUser(userDTO );
        return data;
    }
}
