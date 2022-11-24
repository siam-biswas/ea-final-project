package com.comments.controller;

import com.comments.client.MovieClient;
import com.comments.client.SeriesClient;
import com.comments.client.UserClient;
import com.comments.entity.Comments;
import com.comments.entity.ContentType;
import com.comments.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService service;
    private final UserClient userClient;

    private final MovieClient movieClient;
    private final SeriesClient seriesClient;

    public CommentController(CommentService commentService, UserClient userClient, MovieClient movieClient, SeriesClient seriesClient) {
        this.service = commentService;
        this.userClient = userClient;
        this.movieClient = movieClient;
        this.seriesClient = seriesClient;
    }

    @GetMapping
    public ResponseEntity<List<Comments>> getAllComments() {
        var result = service.getAllComments().stream().map(value -> {
            var user = userClient.get(value.getUserId());
            value.setUser(user);

            if (value.getContent().getContentType() == ContentType.movie) {
                var movie = movieClient.get(value.getContent().getContentId());
                value.setMovie(movie);
            }

            if (value.getContent().getContentType() == ContentType.series) {
                var series = seriesClient.get(value.getContent().getContentId());
                value.setSeries(series);
            }


            return value;
        }).toList();

        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comments> getCommentsById(@PathVariable(value = "id") Long id) {

        Optional<Comments> data = service.getCommentsById(id).map(value -> {
            var user = userClient.get(value.getUserId());
            value.setUser(user);

            if (value.getContent().getContentType() == ContentType.movie) {
                var movie = movieClient.get(value.getContent().getContentId());
                value.setMovie(movie);
            }

            if (value.getContent().getContentType() == ContentType.series) {
                var series = seriesClient.get(value.getContent().getContentId());
                value.setSeries(series);
            }

            return value;
        });

        if (data.isPresent()) {
            return ResponseEntity.ok(data.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Object> AddComment(@RequestBody Comments comments) {
        Optional<Comments> data = Optional.ofNullable(service.AddComment(comments)).map(value -> {
            var user = userClient.get(value.getUserId());
            value.setUser(user);

            if (value.getContent().getContentType() == ContentType.movie) {
                var movie = movieClient.get(value.getContent().getContentId());
                value.setMovie(movie);
            }

            if (value.getContent().getContentType() == ContentType.series) {
                var series = seriesClient.get(value.getContent().getContentId());
                value.setSeries(series);
            }
            return value;
        });

        if (data.isPresent()) {
            return ResponseEntity.ok(data.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public void DeleteComment(@PathVariable Long id) {
        service.DeleteComment(id);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> UpdateComment(@RequestBody Comments comments) {
        Optional<Comments> data = Optional.ofNullable(service.UpdateComment(comments)).map(value -> {
            var user = userClient.get(value.getUserId());
            value.setUser(user);

            if (value.getContent().getContentType() == ContentType.movie) {
                var movie = movieClient.get(value.getContent().getContentId());
                value.setMovie(movie);
            }

            if (value.getContent().getContentType() == ContentType.series) {
                var series = seriesClient.get(value.getContent().getContentId());
                value.setSeries(series);
            }
            return value;
        });

        if (data.isPresent()) {
            return ResponseEntity.ok(data.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
