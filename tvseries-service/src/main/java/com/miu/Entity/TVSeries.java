package com.miu.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "series")
public class TVSeries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String title;
    int numberOfSeasons;
    int numberOfEpisodes;
    int durationInMinutes;
    String genre;
    String director;
    LocalDate releaseDate;

    @OneToMany(mappedBy = "series", fetch = FetchType.EAGER)
    @JsonIgnore
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    List<ActorsSeries> actorsSeries;
}
