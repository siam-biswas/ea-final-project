package com.comments.client;

import com.comments.dto.SeriesDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(name = "TVSERIES-SERVICE")
public interface SeriesClient {

    @GetMapping("/tvseries/finallseries")
    List<SeriesDTO> getAll();

    @GetMapping("/tvseries/{id}")
    SeriesDTO get(@PathVariable(name = "id") Long id);

}