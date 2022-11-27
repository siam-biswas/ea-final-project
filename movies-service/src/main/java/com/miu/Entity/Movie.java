package com.miu.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Data
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String Title;
    int durationInMinutes;
    String genre;
    String director;
    LocalDate releaseDate;

    @OneToMany(mappedBy = "movie", fetch = FetchType.EAGER)
    @JsonIgnore
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    List<ActorsMovies> actorsMovies;

}
