package com.miu.userservice.service;

import com.miu.userservice.entity.Users;
import com.miu.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService extends CrudService<Users,UserRepository> {


    public UserService(UserRepository repository) {
        super(repository);
    }
}
