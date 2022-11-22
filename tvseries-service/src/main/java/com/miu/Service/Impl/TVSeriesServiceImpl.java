package com.miu.Service.Impl;


import com.miu.Entity.TVSeries;
import com.miu.Repository.TVSeriesRepo;
import com.miu.Service.TVSeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TVSeriesServiceImpl  implements TVSeriesService {

    @Autowired
    TVSeriesRepo tvSeriesRepo;

    @Override
    public TVSeries findById(int seriesId) {
        return tvSeriesRepo.findTVSeriesById(seriesId);
    }

    @Override
    public void deleteById(int seriesId) {
        tvSeriesRepo.deleteById(seriesId);
    }

    @Override
    public void Update(TVSeries series) {
        tvSeriesRepo.save(series);
    }

    @Override
    public void addTVSeries(TVSeries series) {
        tvSeriesRepo.save(series);
    }
}
