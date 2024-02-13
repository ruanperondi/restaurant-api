package com.alphasights.restaurant.domain.entity;

public record Cuisine(Integer id, String name) {
    public Cuisine {
        if (name == null) {
            throw new IllegalArgumentException("Cuisine Name cannot be null");
        }
    }
}
