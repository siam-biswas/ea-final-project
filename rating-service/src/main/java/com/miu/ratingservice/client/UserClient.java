package com.miu.ratingservice.client;

import com.miu.ratingservice.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;



@FeignClient(name = "USER-SERVICE",url = "http://localhost:8081/api/v1")
public interface UserClient {

    @GetMapping("/users")
    List<UserDTO> getAll();

    @GetMapping("/users/{id}")
    UserDTO get(@PathVariable Long id);

}