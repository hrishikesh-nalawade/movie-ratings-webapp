package com.microservicestutorial.movieinfoservice.controller;

import com.microservicestutorial.movieinfoservice.model.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @GetMapping("/{movieId}")
    public List<Movie> getMovieInfo(
            @PathVariable("movieId") String movieId) {

        //As the aim is to understand how Microservices work together, we'll hardcode the response as of now.
        Movie movie1 = Movie.builder()
                .name("Transformers")
                .movieId("Trans01")
                .description("Movie description")
                .build();

        Movie movie2 = Movie.builder()
                .name("Transformers: Age of Megatron")
                .movieId("Trans01")
                .description("Movie description")
                .build();

        List<Movie> movies = new ArrayList<>();

        movies.add(movie1);
        movies.add(movie2);

        return movies;
    }

}
