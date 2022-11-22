package com.miu.userservice.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Favorite implements Identifiable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Content content;

    @ManyToOne
    private Users user;

}
