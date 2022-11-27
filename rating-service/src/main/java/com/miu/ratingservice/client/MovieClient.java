package com.miu.ratingservice.client;

import com.miu.ratingservice.dto.MovieDTO;
import com.miu.ratingservice.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;



@FeignClient(name = "MOVIE-SERVICE")
public interface MovieClient {

    @GetMapping("/movies/getallmovies")
    List<MovieDTO> getAll();

    @GetMapping("/movies/getbyid")
    MovieDTO get(@RequestParam(value = "movieId") int id);

}