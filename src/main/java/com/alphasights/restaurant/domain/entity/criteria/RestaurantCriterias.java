package com.alphasights.restaurant.domain.entity.criteria;

import com.alphasights.restaurant.domain.entity.Restaurant;
import com.alphasights.restaurant.domain.entity.criteria.impl.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum RestaurantCriterias {
    NAME(new RestaurantNameCriteria()),
    CUISINE(new RestaurantCuisineCriteria()),
    CUSTOMER_RATING(new RestaurantCustomerRatingCriteria()),
    PRICE(new RestaurantPriceCriteria()),
    DISTANCE(new RestaurantDistanceCriteria());

    private final RestaurantCriteria criteria;

    public boolean belongs(Restaurant restaurant, Restaurant search) {
        return criteria.belongs(restaurant, search);
    }
}
