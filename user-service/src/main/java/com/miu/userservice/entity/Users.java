package com.miu.userservice.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "users")
@Data
public class Users implements Identifiable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    @JsonIgnore
    private String password;

    @Override
    public Long getId() {
        return id;
    }
}
