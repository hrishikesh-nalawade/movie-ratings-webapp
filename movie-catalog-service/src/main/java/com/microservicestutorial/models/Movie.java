package com.microservicestutorial.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Movie {
    private String id;
    private String title;
    private String overview;
    @JsonProperty("release_date")
    private String releaseDate;

}
