package com.miu.Service.Impl;


import com.miu.Entity.TVSeries;
import com.miu.Enum.FilterType;
import com.miu.Repository.TVSeriesRepo;
import com.miu.Service.TVSeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Service
public class TVSeriesServiceImpl implements TVSeriesService {

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
    @Override
    public List<TVSeries> filterSeries(int filterType, String value) {

        switch (filterType) {
            case 1:
                return tvSeriesRepo.findAllByGenre(value);
            case 2:
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
                formatter = formatter.withLocale(Locale.US);
                LocalDate date = LocalDate.parse(value, formatter);
                return tvSeriesRepo.findAllByReleaseDate(date);
            case 3:
                return tvSeriesRepo.findAllByDirector(value);
            case 4:
                return tvSeriesRepo.findAllByDurationInMinutes(Integer.parseInt(value));
        }

        return null;
    }


}
