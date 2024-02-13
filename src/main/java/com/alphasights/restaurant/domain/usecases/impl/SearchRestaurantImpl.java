package com.alphasights.restaurant.domain.usecases.impl;

import com.alphasights.restaurant.domain.entity.Cuisine;
import com.alphasights.restaurant.domain.entity.Restaurant;
import com.alphasights.restaurant.domain.entity.criteria.RestaurantCriterias;
import com.alphasights.restaurant.domain.ports.SearchAllRestaurantsPort;
import com.alphasights.restaurant.domain.usecases.SearchRestaurant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class SearchRestaurantImpl implements SearchRestaurant {

    private final SearchAllRestaurantsPort searchAllRestaurantsPort;
    private final Integer maxReturnValues;
    private final Comparator<Restaurant> sortRestaurant;

    @Override
    public List<Restaurant> search(Restaurant criteria) {
        log.info("Searching restaurants with criteria: {}", criteria);

        List<RestaurantCriterias> criterias = Arrays.stream(RestaurantCriterias.values()).toList();

        List<Restaurant> restaurants = searchAllRestaurantsPort.getRestaurants();
        log.info("Found {} restaurants", restaurants.size());
        
        List<Restaurant> results = restaurants.stream().filter(r -> criterias.stream().allMatch(c -> c.belongs(r, criteria))).sorted(sortRestaurant).toList();
        log.info("Filtered {} restaurants", results.size());

        if (CollectionUtils.isEmpty(results)) {
            log.info("No restaurants found");

            return Collections.emptyList();
        }

        return results.subList(0, Math.min(maxReturnValues, results.size()));
    }
}
