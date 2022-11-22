package com.miu.Service;

import com.miu.Entity.Movie;

public interface MovieService {
    Movie findById(int id);

    void deleteById(int id);

    void Update(Movie movie);

    void addMovie(Movie movie);
}
