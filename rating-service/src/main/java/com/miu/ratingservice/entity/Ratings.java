package com.miu.ratingservice.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
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

    private Long contentId;
    private Integer contentType;
    private Integer value;

//    @Transient
//    private UserDTO user;


    @Override
    public Long getId() {
        return id;
    }
}
