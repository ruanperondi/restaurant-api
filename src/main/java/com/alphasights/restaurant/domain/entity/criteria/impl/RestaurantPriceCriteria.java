package com.alphasights.restaurant.domain.entity.criteria.impl;

import com.alphasights.restaurant.domain.entity.Restaurant;
import com.alphasights.restaurant.domain.entity.criteria.RestaurantCriteria;


public class RestaurantPriceCriteria implements RestaurantCriteria {

    @Override
    public boolean belongs(Restaurant restaurant, Restaurant comparision) {
        if (comparision.getPrice() == null) {
            return true;
        }
        
        return restaurant.getPrice().compareTo(comparision.getPrice()) <= 0;
    }
}
