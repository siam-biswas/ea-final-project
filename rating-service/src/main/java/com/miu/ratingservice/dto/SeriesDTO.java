package com.miu.ratingservice.dto;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
public class SeriesDTO {
    int id;

    String title;
    int numberOfSeasons;
    int numberOfEpisodes;
    int durationInMinutes;
    String genre;
    String director;
    LocalDate releaseDate;
}
