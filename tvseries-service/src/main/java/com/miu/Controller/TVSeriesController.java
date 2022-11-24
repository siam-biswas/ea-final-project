package com.miu.Controller;


import com.miu.Entity.TVSeries;
import com.miu.Enum.FilterType;
import com.miu.Service.Impl.TVSeriesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/tvseries")
@RestController
public class TVSeriesController {
    @Autowired
    TVSeriesServiceImpl tvSeriesService;

    @PostMapping
    public void addMovie(@RequestParam TVSeries series){
        tvSeriesService.addTVSeries(series);
    }

    @PutMapping
    public void updateMovie(@RequestParam TVSeries series){
        tvSeriesService.Update(series);
    }

    @DeleteMapping
    public void delete(@RequestParam int seriesId){
        tvSeriesService.deleteById(seriesId);
    }

    @GetMapping("findbyid")
    public TVSeries getMovieById(int seriesId){
        return  tvSeriesService.findById(seriesId);
    }

    @GetMapping("filter")
    List<TVSeries> filterBy(@RequestParam FilterType filterType, @RequestParam String value) {
        return tvSeriesService.filterSeries(filterType, value);
    }


}
