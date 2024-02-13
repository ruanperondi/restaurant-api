package com.alphasights.restaurant.config.ports;

import com.alphasights.restaurant.adapters.persistence.csv.RestaurantsCSVRepository;
import com.alphasights.restaurant.domain.ports.SearchAllRestaurantsPort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SearchAllRestaurantsPortConfig {

    @Bean
    SearchAllRestaurantsPort searchAllRestaurantsPort(
            @Value("${restaurants.csv.cuisines}") String cuisineCSVFilePath,
            @Value("${restaurants.csv.restaurants}") String restaurantCSVFilePath
    ) {
        return new RestaurantsCSVRepository(restaurantCSVFilePath, cuisineCSVFilePath);
    }
}
