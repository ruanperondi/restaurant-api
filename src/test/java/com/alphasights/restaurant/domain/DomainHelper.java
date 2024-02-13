package com.alphasights.restaurant.domain;

import com.alphasights.restaurant.domain.entity.Cuisine;

public class DomainHelper {
    public static Cuisine createCuisine() {
        return new Cuisine(1, "Italian");
    }
}
