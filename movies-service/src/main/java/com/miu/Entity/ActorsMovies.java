package com.miu.Entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class ActorsMovies {
    @EmbeddedId
    ActorsMoviesId id;

    @MapsId("actorId")
    @ManyToOne
    Actor actor;

    @MapsId("movieId")
    @ManyToOne
    Movie movie;

}
