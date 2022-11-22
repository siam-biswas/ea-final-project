package com.miu.userservice.service;

import com.miu.userservice.entity.Favorite;
import com.miu.userservice.repository.FavoriteRepository;
import com.miu.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FavoriteService extends CrudService<Favorite, FavoriteRepository> {


    public FavoriteService(FavoriteRepository repository) {
        super(repository);
    }
}

