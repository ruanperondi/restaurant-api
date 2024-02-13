package com.alphasights.restaurant.domain.entity.criteria.impl;

import com.alphasights.restaurant.domain.entity.Restaurant;
import com.alphasights.restaurant.domain.entity.criteria.RestaurantCriteria;


public class RestaurantNameCriteria implements RestaurantCriteria {

    @Override
    public boolean belongs(Restaurant restaurant, Restaurant comparision) {
        if (comparision.getName() == null) {
            return true;
        }

        return restaurant.getName().toLowerCase().contains(comparision.getName().toLowerCase());
    }

}
