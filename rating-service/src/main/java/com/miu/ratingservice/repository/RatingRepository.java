package com.miu.ratingservice.repository;

import com.miu.ratingservice.entity.Ratings;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends CrudRepositoryInterface<Ratings> {
}
