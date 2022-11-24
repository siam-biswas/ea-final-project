package com.miu.Service;

import com.miu.Entity.Movie;
import com.miu.Enum.FilterType;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface MovieService {
    Movie findById(int id);

    void deleteById(int id);

    void Update(Movie movie);

    void addMovie(Movie movie);

    List<Movie> filterMovie(FilterType filterType, String value);
}
