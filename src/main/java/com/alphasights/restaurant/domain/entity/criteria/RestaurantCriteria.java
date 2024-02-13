package com.alphasights.restaurant.domain.entity.criteria;

import com.alphasights.restaurant.domain.entity.Restaurant;

public interface RestaurantCriteria {

    boolean belongs(Restaurant restaurant, Restaurant comparision);
}
