package com.miu.Repository;

import com.miu.Entity.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface MovieRepo extends CrudRepository<Movie, Integer> {
    List<Movie> findAllByGenre(String genre);

    List<Movie> findAllByDirector(String director);

    List<Movie> findAllByDurationInMinutes(int minutes);

    List<Movie> findAllByReleaseDate(LocalDate year);

}
