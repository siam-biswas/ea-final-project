package com.miu.Service.Impl;

import com.miu.Entity.Movie;
import com.miu.Enum.FilterType;
import com.miu.Repository.ActorMovieRepo;
import com.miu.Repository.MovieRepo;
import com.miu.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepo movieRepo;
    @Autowired
    ActorMovieRepo actorMovieRepo;

    @Override
    public Movie findById(int movieId) {
        return movieRepo.findById(movieId).get();
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

    @Override
    public List<Movie> filterMovie(FilterType filterType, String value) {
        switch (filterType) {
            case GENRE:
                return movieRepo.findAllByGenre(value);
            case RELEASE_DATE:
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                formatter = formatter.withLocale(Locale.US);
                LocalDate date = LocalDate.parse(value, formatter);
                return movieRepo.findAllByReleaseDate(date);
            case DIRECTOR:
                return movieRepo.findAllByDirector(value);
            case DURATION:
                return movieRepo.findAllByDurationInMinutes(Integer.parseInt(value));
            case ACTOR:
                return actorMovieRepo.findAllByActor_FirstName(value)
                        .stream()
                        .map(x -> x.getMovie())
                        .collect(Collectors.toList());
            default:
                return null;
        }
    }

    @Override
    public List<Movie> findAll() {
        return movieRepo.findAll();
    }


}
