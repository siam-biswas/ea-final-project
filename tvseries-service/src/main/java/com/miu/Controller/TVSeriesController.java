package com.miu.Controller;


import com.miu.Entity.TVSeries;
import com.miu.Service.Impl.TVSeriesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("tvseries")
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

    @GetMapping
    public TVSeries getMovieById(int seriesId){
        return  tvSeriesService.findById(seriesId);
    }
}
