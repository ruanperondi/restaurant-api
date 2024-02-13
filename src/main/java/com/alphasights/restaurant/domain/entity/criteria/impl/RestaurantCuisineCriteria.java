package com.alphasights.restaurant.domain.entity.criteria.impl;

import com.alphasights.restaurant.domain.entity.Restaurant;
import com.alphasights.restaurant.domain.entity.criteria.RestaurantCriteria;


public class RestaurantCuisineCriteria implements RestaurantCriteria {

    @Override
    public boolean belongs(Restaurant restaurant, Restaurant comparision) {
        if (restaurant.getCuisine() == null || comparision.getCuisine() == null) {
            return true;
        }

        return restaurant.getCuisine().name().toLowerCase().contains(comparision.getCuisine().name().toLowerCase());
    }
}
