package com.miu.ratingservice.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.miu.ratingservice.dto.MovieDTO;
import com.miu.ratingservice.dto.SeriesDTO;
import com.miu.ratingservice.dto.UserDTO;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Ratings implements Identifiable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    private Long userId;

    @Embedded
    private Content content;
    private Integer value;

    @Transient
    private UserDTO user;

    @Transient
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private MovieDTO movie;

    @Transient
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private SeriesDTO series;


    @Override
    public Long getId() {
        return id;
    }
}
