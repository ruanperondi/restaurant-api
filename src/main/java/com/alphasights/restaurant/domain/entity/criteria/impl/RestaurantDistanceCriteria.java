package com.alphasights.restaurant.domain.entity.criteria.impl;

import com.alphasights.restaurant.domain.entity.Restaurant;
import com.alphasights.restaurant.domain.entity.criteria.RestaurantCriteria;


public class RestaurantDistanceCriteria implements RestaurantCriteria {

    @Override
    public boolean belongs(Restaurant restaurant, Restaurant comparision) {
        if (comparision.getDistance() == null) {
            return true;
        }

        return restaurant.getDistance() <= comparision.getDistance();
    }

}
