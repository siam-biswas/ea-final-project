package com.miu.ratingservice.repository;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EnableJpaRepositories(
        basePackages = {"com.miu.ratingservice.repository"},
        repositoryBaseClass = CrudRepository.class
)
class RepositoryConfig{ }
