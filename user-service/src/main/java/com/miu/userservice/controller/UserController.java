package com.miu.userservice.controller;

import com.miu.userservice.entity.Users;
import com.miu.userservice.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController extends CrudController<Users, UserService> {


    public UserController(UserService service) {
        super(service);
    }


}
