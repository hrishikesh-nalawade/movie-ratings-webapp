package com.microservicestutorial.models;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Rating {

    private String movieId;
    private int rating;
}
