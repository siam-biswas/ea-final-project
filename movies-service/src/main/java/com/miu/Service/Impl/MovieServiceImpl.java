package com.miu.Service.Impl;

import com.miu.Entity.Movie;
import com.miu.Repository.MovieRepo;
import com.miu.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepo movieRepo;

    @Override
    public Movie findById(int movieId) {
        return movieRepo.findMovieById(movieId);
    }

    @Override
    public void deleteById(int movieId) {
        movieRepo.deleteById(movieId);
    }

    @Override
    public void Update(Movie movie) {
        movieRepo.save(movie);
    }

    @Override
    public void addMovie(Movie movie) {
        movieRepo.save(movie);
    }
}
