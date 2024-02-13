package com.alphasights.restaurant.domain.entity;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
public class Restaurant {
    private final UUID id;
    private final String name;
    private final Integer rating;
    private final Integer distance;
    private final Integer price;
    private final Cuisine cuisine;

    @Builder
    public Restaurant(UUID id, String name, Integer rating, Integer distance, Integer price, Cuisine cuisine) {
        if (name == null) {
            throw new IllegalArgumentException("Restaurant Name cannot be null");
        }

        if (rating == null || rating < 0 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 0 and 5");
        }

        if (distance == null || distance < 0) {
            throw new IllegalArgumentException("Distance must be greater than 0");
        }

        if (price == null || price < 0) {
            throw new IllegalArgumentException("Price must be greater than 0");
        }

        if (cuisine == null) {
            throw new IllegalArgumentException("Cuisine cannot be null");
        }

        this.id = id == null ? UUID.randomUUID() : id;
        this.name = name;
        this.rating = rating;
        this.distance = distance;
        this.price = price;
        this.cuisine = cuisine;
    }

    public Restaurant(String name, Integer rating, Integer distance, Integer price, Cuisine cuisine) {
        this.name = name;
        this.rating = rating;
        this.distance = distance;
        this.price = price;
        this.cuisine = cuisine;
        this.id = null;
    }
}
