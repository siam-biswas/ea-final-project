package com.miu.userservice.service;

import com.miu.userservice.entity.Users;
import com.miu.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService extends CrudService<Users,UserRepository> {


    public UserService(UserRepository repository) {
        super(repository);
    }

    public Optional<Users> getByUserName(String value){
        return repository.findByUserName(value).stream().findFirst();
    }

}
