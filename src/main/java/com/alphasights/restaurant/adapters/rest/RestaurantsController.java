package com.alphasights.restaurant.adapters.rest;

import com.alphasights.restaurant.domain.entity.Cuisine;
import com.alphasights.restaurant.domain.entity.Restaurant;
import com.alphasights.restaurant.domain.usecases.SearchRestaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
public class RestaurantsController {

    private final SearchRestaurant searchRestaurant;

    @GetMapping(produces = "application/json")
    public List<Restaurant> searchRestaurants(@RequestParam(required = false) String name,
                                              @RequestParam(required = false) String cuisine,
                                              @RequestParam(required = false) Integer rating,
                                              @RequestParam(required = false) Integer distance,
                                              @RequestParam(required = false) Integer price
    ) {
        Restaurant restaurant = new Restaurant(name, rating, distance, price, cuisine != null ? new Cuisine(null, cuisine) : null);

        return searchRestaurant.search(restaurant);
    }
}
