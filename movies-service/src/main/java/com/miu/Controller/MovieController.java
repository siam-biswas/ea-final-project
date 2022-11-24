package com.miu.Controller;


import com.miu.Entity.ActorsMovies;
import com.miu.Entity.Movie;
import com.miu.Enum.FilterType;
import com.miu.Repository.ActorMovieRepo;
import com.miu.Service.Impl.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/movies")
@RestController
public class MovieController {

    @Autowired
    MovieServiceImpl movieService;


    @PostMapping
    public void addMovie(@RequestParam Movie movie) {
        movieService.addMovie(movie);
    }

    @PutMapping
    public void updateMovie(@RequestParam Movie movie) {
        movieService.Update(movie);
    }

    @DeleteMapping
    public void delete(@RequestParam int movieId) {
        movieService.deleteById(movieId);
    }

    @GetMapping("getbyid")
    public Movie getMovieById(int movieId) {
        return movieService.findById(movieId);
    }

    @GetMapping("filter")
    List<Movie> filterBy(@RequestParam FilterType filterType, @RequestParam String value) {
        return movieService.filterMovie(filterType, value);
    }
}
