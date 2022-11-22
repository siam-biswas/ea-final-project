package com.miu.Service;

import com.miu.Entity.TVSeries;

public interface TVSeriesService {
    TVSeries findById(int seriesId);
    void deleteById(int seriesId);
    void Update(TVSeries series);
    void addTVSeries(TVSeries series);

}
