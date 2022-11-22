package com.miu.ratingservice.controller;

import com.miu.ratingservice.client.UserClient;
import com.miu.ratingservice.entity.Ratings;
import com.miu.ratingservice.service.RatingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/ratings")
public class RatingController extends CrudController<Ratings, RatingService> {

    private final UserClient userClient;

    public RatingController(RatingService service, UserClient userClient) {
        super(service);
        this.userClient = userClient;
    }


    @Override
    @GetMapping
    public ResponseEntity<List<Ratings>> getAll() {

        var result = service.getAll().stream().map( value ->{
            var user =  userClient.get(value.getUserId());
            value.setUser(user);
            return value;
        }).toList();

        return ResponseEntity.ok(result);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Ratings> get(@PathVariable Long id) {

        Optional<Ratings> data = service.get(id).map( value ->{
            var user =  userClient.get(value.getUserId());
            value.setUser(user);
            return value;
        });

        if (data.isPresent()) {
            return ResponseEntity.ok(data.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
