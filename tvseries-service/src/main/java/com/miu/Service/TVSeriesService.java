package com.miu.Service;


import com.miu.Entity.TVSeries;
import com.miu.Enum.FilterType;
import java.util.List;

public interface TVSeriesService {
    TVSeries findById(Long seriesId);
    void deleteById(Long seriesId);
    void Update(TVSeries series);
    void addTVSeries(TVSeries series);
    List<TVSeries> filterSeries(FilterType filterType , String value);

    List<TVSeries> findAllSeries();


}
