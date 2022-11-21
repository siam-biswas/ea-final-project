package com.miu.userservice.repository;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EnableJpaRepositories(
        basePackages = {"com.miu.userservice.repository"},
        repositoryBaseClass = CrudRepository.class
)
class RepositoryConfig{ }
