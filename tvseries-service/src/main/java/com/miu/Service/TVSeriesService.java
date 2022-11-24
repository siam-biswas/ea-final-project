package com.miu.Service;

import com.miu.Entity.TVSeries;
import com.miu.Enum.FilterType;

import java.time.LocalDate;
import java.util.List;

public interface TVSeriesService {
    TVSeries findById(int seriesId);
    void deleteById(int seriesId);
    void Update(TVSeries series);
    void addTVSeries(TVSeries series);
    List<TVSeries> filterSeries(FilterType filterType , String value);

}
