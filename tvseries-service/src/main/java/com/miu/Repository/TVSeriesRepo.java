package com.miu.Repository;

import com.miu.Entity.TVSeries;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TVSeriesRepo  extends CrudRepository<TVSeries , Integer> {

    TVSeries findTVSeriesById(int seriesId);
}
