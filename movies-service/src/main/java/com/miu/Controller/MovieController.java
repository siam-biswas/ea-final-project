package com.miu.Controller;


import com.miu.Entity.Movie;
import com.miu.Service.Impl.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("movies")
@RestController
public class MovieController {

    @Autowired
    MovieServiceImpl movieService;

    @PostMapping
    public void addMovie(@RequestParam Movie movie){
        movieService.addMovie(movie);
    }

    @PutMapping
    public void updateMovie(@RequestParam Movie movie){
        movieService.Update(movie);
    }

    @DeleteMapping
    public void delete(@RequestParam int movieId){
        movieService.deleteById(movieId);
    }

    @GetMapping
    public Movie getMovieById(int movieId){
        return  movieService.findById(movieId);
    }
}
