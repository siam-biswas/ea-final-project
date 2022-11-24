package com.miu.Entity;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "series")
public class TVSeries {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String title;
    int numberOfSeasons;
    int numberOfEpisodes;
    int durationInMinutes;
    String genre;
    String director;
    LocalDate releaseDate;

    @OneToMany(mappedBy = "series" , fetch = FetchType.EAGER)
    List<ActorsSeries> actorsSeries;
}
