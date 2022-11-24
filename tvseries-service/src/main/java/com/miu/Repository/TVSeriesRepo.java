package com.miu.Repository;


import com.miu.Entity.TVSeries;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface TVSeriesRepo  extends CrudRepository<TVSeries , Integer> {

    TVSeries findTVSeriesById(int seriesId);
    List<TVSeries> findAllByReleaseDate(LocalDate year);
    List<TVSeries> findAllByGenre(String genre);
    List<TVSeries> findAllByDirector(String director);
    List<TVSeries> findAllByDurationInMinutes(int minutes);

}
