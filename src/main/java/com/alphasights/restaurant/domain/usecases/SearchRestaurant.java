package com.alphasights.restaurant.domain.usecases;

import com.alphasights.restaurant.domain.entity.Restaurant;

import java.util.List;

public interface SearchRestaurant {

    public List<Restaurant> search(Restaurant criteria);
}
