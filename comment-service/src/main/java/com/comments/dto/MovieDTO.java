package com.comments.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MovieDTO {

    int id;

    String Title;
    int durationInMinutes;
    String genre;
    String director;
    LocalDate releaseDate;
}