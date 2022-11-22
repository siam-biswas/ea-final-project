package com.miu.Entity;


import lombok.Data;

import javax.persistence.*;

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
    String genre;

}
