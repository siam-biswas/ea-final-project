package com.comments.entity;


import com.comments.dto.MovieDTO;
import com.comments.dto.SeriesDTO;
import com.comments.dto.UserDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String comment;

    private Long userId;

    private Long movieId;

    private Long seriesId;

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

}
