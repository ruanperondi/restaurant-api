package com.alphasights.restaurant.domain.entity.criteria.impl;

import com.alphasights.restaurant.domain.entity.Restaurant;
import com.alphasights.restaurant.domain.entity.criteria.RestaurantCriteria;

public class RestaurantCustomerRatingCriteria implements RestaurantCriteria {

    @Override
    public boolean belongs(Restaurant restaurant, Restaurant comparision) {
        if (comparision.getRating() == null) {
            return true;
        }

        return restaurant.getRating() >= comparision.getRating();
    }

}
