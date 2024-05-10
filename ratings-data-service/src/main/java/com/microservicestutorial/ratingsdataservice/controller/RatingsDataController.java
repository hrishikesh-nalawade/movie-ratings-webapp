package com.microservicestutorial.ratingsdataservice.controller;

import com.microservicestutorial.ratingsdataservice.model.Rating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ratingsData")
public class RatingsDataController {

   @GetMapping("/{movieId}")
    public List<Rating> getratingsData(@PathVariable("movieId") String movieId) {

       //As the aim is to understand how Microservices work together, we'll hardcode the response as of now.

       List<Rating> ratings = new ArrayList<>();

      Rating rating1 = Rating.builder()
              .movieId("Trans01")
              .rating(3)
              .build();
      Rating rating2 = Rating.builder()
              .movieId("Trans02")
              .rating(4)
              .build();

      ratings.add(rating1);
      ratings.add(rating2);
       return ratings;
   }
}
