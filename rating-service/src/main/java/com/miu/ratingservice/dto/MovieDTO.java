package com.miu.ratingservice.dto;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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