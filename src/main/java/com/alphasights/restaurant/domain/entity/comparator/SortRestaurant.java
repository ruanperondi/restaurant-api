package com.alphasights.restaurant.domain.entity.comparator;

import com.alphasights.restaurant.domain.entity.Restaurant;

import java.util.Comparator;

public class SortRestaurant implements Comparator<Restaurant> {

    @Override
    public int compare(Restaurant restaurant1, Restaurant restaurant2) {
        if (restaurant1.getDistance() < restaurant2.getDistance()) {
            return -1;
        }

        if (restaurant1.getDistance() > restaurant2.getDistance()) {
            return 1;
        }

        if (restaurant1.getRating() > restaurant2.getRating()) {
            return -1;
        }

        if (restaurant1.getRating() < restaurant2.getRating()) {
            return 1;
        }

        return restaurant1.getPrice().compareTo(restaurant2.getPrice());
    }
}