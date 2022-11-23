package com.miu.ratingservice.dto;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class SeriesDTO {
    int id;

    String title;
    int numberOfSeasons;
    int numberOfEpisodes;
    String genre;
}
