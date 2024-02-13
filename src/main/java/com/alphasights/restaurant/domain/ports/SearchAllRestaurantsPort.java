package com.alphasights.restaurant.domain.ports;

import com.alphasights.restaurant.domain.entity.Restaurant;

import java.util.List;

public interface SearchAllRestaurantsPort {
    List<Restaurant> getRestaurants();
}
