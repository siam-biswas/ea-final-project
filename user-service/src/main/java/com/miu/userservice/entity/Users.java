package com.miu.userservice.entity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Users implements Identifiable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;


    @Override
    public Long getId() {
        return id;
    }
}
