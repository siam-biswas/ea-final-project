package com.miu.ratingservice.controller;

import com.miu.ratingservice.client.MovieClient;
import com.miu.ratingservice.client.SeriesClient;
import com.miu.ratingservice.client.UserClient;
import com.miu.ratingservice.entity.ContentType;
import com.miu.ratingservice.entity.Ratings;
import com.miu.ratingservice.service.RatingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ratings")
public class RatingController extends CrudController<Ratings, RatingService> {

    private final UserClient userClient;
    private final MovieClient movieClient;
    private final SeriesClient seriesClient;

    public RatingController(RatingService service, UserClient userClient, MovieClient movieClient, SeriesClient seriesClient) {
        super(service);
        this.userClient = userClient;
        this.movieClient = movieClient;
        this.seriesClient = seriesClient;
    }


    @Override
    @GetMapping
    public ResponseEntity<List<Ratings>> getAll() {

        var result = service.getAll().stream().map( value ->{
            var user =  userClient.get(value.getUserId());
            value.setUser(user);

            if (value.getContent().getContentType() == ContentType.movie){
                var movie = movieClient.get(value.getContent().getContentId().intValue());
                value.setMovie(movie);
            }

            if (value.getContent().getContentType() == ContentType.series){
                var series = seriesClient.get(value.getContent().getContentId());
                value.setSeries(series);
            }


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

            if (value.getContent().getContentType() == ContentType.movie){
                var movie = movieClient.get(value.getContent().getContentId().intValue());
                value.setMovie(movie);
            }

            if (value.getContent().getContentType() == ContentType.series){
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
