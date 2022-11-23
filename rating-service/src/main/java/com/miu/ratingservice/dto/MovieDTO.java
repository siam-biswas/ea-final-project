package com.miu.ratingservice.dto;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class MovieDTO {

    int id;
    String Title;
    int durationInMinutes;
}