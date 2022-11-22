package com.miu.Repository;

import com.miu.Entity.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MovieRepo extends CrudRepository<Movie, Integer> {
    Movie findMovieById(int movieId);
}
