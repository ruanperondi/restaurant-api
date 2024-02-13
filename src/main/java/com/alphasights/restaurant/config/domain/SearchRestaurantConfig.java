package com.alphasights.restaurant.config.domain;

import com.alphasights.restaurant.domain.entity.Restaurant;
import com.alphasights.restaurant.domain.entity.comparator.SortRestaurant;
import com.alphasights.restaurant.domain.ports.SearchAllRestaurantsPort;
import com.alphasights.restaurant.domain.usecases.impl.SearchRestaurantImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Comparator;

@Configuration
public class SearchRestaurantConfig {


    @Bean
    SearchRestaurantImpl searchRestaurantImpl(
            @Value("${restaurants.list.max}") Integer maxListReturn,
            SearchAllRestaurantsPort searchAllRestaurantsPort,
            Comparator<Restaurant> sortRestaurant

    ) {
        return new SearchRestaurantImpl(
                searchAllRestaurantsPort, maxListReturn, sortRestaurant
        );
    }

    @Bean
    Comparator<Restaurant> sortRestaurant() {
        return new SortRestaurant();
    }
}
