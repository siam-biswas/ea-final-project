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
    private final
    TVSeriesServiceImpl tvSeriesService;

    public TVSeriesController(TVSeriesServiceImpl tvSeriesService) {
        this.tvSeriesService = tvSeriesService;
    }

    @PostMapping
    public void addMovie(@RequestParam TVSeries series) {
        tvSeriesService.addTVSeries(series);
    }

    @PutMapping
    public void updateMovie(@RequestParam TVSeries series) {
        tvSeriesService.Update(series);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        tvSeriesService.deleteById(id);
    }

    @GetMapping("/{id}")
    public TVSeries getMovieById(@PathVariable Long id) {
        return tvSeriesService.findById(id);
    }

    @GetMapping("filter")
    List<TVSeries> filterBy(@RequestParam FilterType filterType, @RequestParam String value) {
        return tvSeriesService.filterSeries(filterType, value);
    }
    @GetMapping("finallseries")
    public List<TVSeries> getAllTVSeries() {
        return tvSeriesService.findAllSeries();
    }

}
