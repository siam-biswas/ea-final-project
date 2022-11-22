package com.miu.Entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "movies")
public class Movie {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    int id;
    String Title;
    int durationInMinutes;

}
