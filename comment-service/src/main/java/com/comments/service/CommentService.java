package com.comments.service;

import com.comments.entity.Comments;
import com.comments.repository.CommentRepository;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class CommentService implements ICommentService {
    private final
    CommentRepository commentRepository;

    private final CircuitBreakerFactory circuitBreakerFactory;

    @Autowired
    public CommentService(CommentRepository commentRepository, CircuitBreakerFactory circuitBreakerFactory) {
        this.commentRepository = commentRepository;
        this.circuitBreakerFactory = circuitBreakerFactory;
    }


    @Override
    public Optional<Comments> getCommentsById(long id) {
        return commentRepository.findAllById(id);
    }

    @Override
    public List<Comments> getAllComments() {

        RestTemplate restTemplate = new RestTemplate();
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");
        String url = "https://jsonplaceholder.typicode.com/posts/1/comments";
        return Collections.singletonList(circuitBreaker.run(() -> restTemplate.getForObject(url, Comments.class), throwable -> getDefaultComment()));
    }

    private Comments getDefaultComment() {
        return new Comments();
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

    @Override
    @RabbitListener(queues = {"deleteSeries"})
    public void DeleteAllBySeriesId(Long seriesId) {
        commentRepository.deleteById(seriesId);
        System.out.println(seriesId);
    }
}
