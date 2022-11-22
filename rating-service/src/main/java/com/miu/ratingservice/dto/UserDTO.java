package com.miu.ratingservice.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
public class UserDTO{

    private Long id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

}