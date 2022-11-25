package com.comments.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SeriesDTO {
    Long id;

    String title;
    int numberOfSeasons;
    int numberOfEpisodes;
    int durationInMinutes;
    String genre;
    String director;
    LocalDate releaseDate;
}
