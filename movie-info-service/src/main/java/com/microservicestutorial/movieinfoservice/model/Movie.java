package com.microservicestutorial.movieinfoservice.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Movie {
    private String movieId;
    private String name;
    private String description;

}
