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
    public List<TVSeries> filterSeries(FilterType filterType, String value) {

        switch (filterType) {
            case GENRE:
                return tvSeriesRepo.findAllByGenre(value);
            case RELEASE_DATE:
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                formatter = formatter.withLocale(Locale.US);
                LocalDate date = LocalDate.parse(value, formatter);
                return tvSeriesRepo.findAllByReleaseDate(date);
            case DIRECTOR:
                return tvSeriesRepo.findAllByDirector(value);
            case DURATION:
                return tvSeriesRepo.findAllByDurationInMinutes(Integer.parseInt(value));
            default:
                return null;
        }
    }


}
