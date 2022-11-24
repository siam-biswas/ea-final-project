package com.miu.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

//@Data
@Data
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
