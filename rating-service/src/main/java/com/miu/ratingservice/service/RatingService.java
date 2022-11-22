package com.miu.ratingservice.service;

import com.miu.ratingservice.repository.RatingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.miu.ratingservice.entity.Ratings;

@Service
@Transactional
public class RatingService extends CrudService<Ratings, RatingRepository> {


    public RatingService(RatingRepository repository) {
        super(repository);
    }
}
