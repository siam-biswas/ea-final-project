package com.miu.userservice.repository;

import com.miu.userservice.entity.Users;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepositoryInterface<Users>{
    List<Users> findByUserName(String userName);
}
