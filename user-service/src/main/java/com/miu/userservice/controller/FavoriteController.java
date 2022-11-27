package com.miu.userservice.controller;

import com.miu.userservice.entity.Favorite;
import com.miu.userservice.service.FavoriteService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/users/favorites")
public class FavoriteController extends CrudController<Favorite, FavoriteService> {


    public FavoriteController(FavoriteService service) {
        super(service);
    }

}