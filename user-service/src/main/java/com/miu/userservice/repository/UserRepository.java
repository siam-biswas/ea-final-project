package com.miu.userservice.repository;

import com.miu.userservice.entity.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepositoryInterface<Users>{
}
