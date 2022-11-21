package com.miu.userservice.entity;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Users implements Identifiable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

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
