package com.microservicestutorial.models;


import lombok.*;


@Getter
@Setter
@Builder(toBuilder = true)
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CatalogItem {
    private String name;
    private String description;
    private int rating;

}
