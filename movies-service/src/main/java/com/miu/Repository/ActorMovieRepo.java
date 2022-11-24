package com.miu.Repository;


import com.miu.Entity.ActorsMovies;
import com.miu.Entity.ActorsMoviesId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorMovieRepo extends CrudRepository<ActorsMovies, ActorsMoviesId> {

    List<ActorsMovies> findAllByActor_FirstName(String fname);
}
