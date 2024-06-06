package com.microservicestutorial.controller;

import com.microservicestutorial.models.CatalogItem;;
import com.microservicestutorial.models.Movie;
import com.microservicestutorial.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
//    private WebClient webClientBuilder;

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        //As the aim is to understand how Microservices work together, we'll hardcode the response as of now.

        //Calling Microservices with help of RestTemplate
        //Note:- we have used  restTemplate.getForEntity() as we want list/array in response, restTemplate.getForObject() could be used in case we are expecting single object.

        //ResponseEntity<Movie[]> movie = restTemplate.getForEntity("http://localhost:8081/movies/trs", Movie[].class);
        //After adding discovery server/eureka server now we will replace "localhost:8081" with application/service name. As done below
        ResponseEntity<Movie> movie = restTemplate.getForEntity("http://movie-info-service/movies/100", Movie.class);

        //similarly localhost:8082 has been replaced with "ratings-data-service"
        ResponseEntity<Rating[]> rating = restTemplate.getForEntity("http://ratings-data-service/ratingsData/trs", Rating[].class);

        Rating[] ratings = rating.getBody();
        Movie movieObject = movie.getBody();

        CatalogItem catalogItem1 = CatalogItem.builder()
                .name(movieObject.getTitle())
                .description(movieObject.getOverview())
                .rating(ratings[0].getRating())
                .build();

        List<CatalogItem> catalogItems = new ArrayList<>();
        catalogItems.add(catalogItem1);

        //Calling Microservices with help of WebClient
        //Note:- WebClient is part of WebFlux, which uses a reactive/functional paradigm to write the code asynchronously.
        //As we don't want to build a WebClient object every time we call this API, we will create a bean for this so that
        //Spring can manage it's object, similarly what we did for RestTemplate.
        //WebClient.Builder builder = WebClient.builder();

//        Mono<Movie[]> movies1 = webClientBuilder.get()
//                .uri("http://localhost:8081/movies/trs")
//                .retrieve()
//                .bodyToMono(Movie[].class)
//                .block();

        return catalogItems;

    }
}