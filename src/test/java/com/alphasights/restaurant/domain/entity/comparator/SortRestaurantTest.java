package com.alphasights.restaurant.domain.entity.comparator;

import com.alphasights.restaurant.domain.DomainHelper;
import com.alphasights.restaurant.domain.entity.Restaurant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SortRestaurantTest {

    @Test
    @DisplayName("If the distance of the first restaurant is less than the distance of the second restaurant, the result should be -1")
    void test01() {
        // Given
        SortRestaurant sortRestaurant = new SortRestaurant();
        Restaurant restaurant1 = Restaurant.builder().name("Restaurant 1").price(10).id(UUID.randomUUID()).rating(2).distance(10).cuisine(DomainHelper.createCuisine()).build();
        Restaurant restaurant2 = Restaurant.builder().name("Restaurant 2").price(20).id(UUID.randomUUID()).rating(2).distance(20).cuisine(DomainHelper.createCuisine()).build();

        int result = sortRestaurant.compare(restaurant1, restaurant2);

        assertEquals(-1, result);
    }

    @Test
    @DisplayName("If the distance of the first restaurant is greater than the distance of the second restaurant, the result should be 1")
    void test02() {
        SortRestaurant sortRestaurant = new SortRestaurant();
        Restaurant restaurant1 = Restaurant.builder().name("Restaurant 1").price(10).id(UUID.randomUUID()).rating(2).distance(20).cuisine(DomainHelper.createCuisine()).build();
        Restaurant restaurant2 = Restaurant.builder().name("Restaurant 2").price(20).id(UUID.randomUUID()).rating(2).distance(10).cuisine(DomainHelper.createCuisine()).build();

        int result = sortRestaurant.compare(restaurant1, restaurant2);

        assertEquals(1, result);
    }

    @Test
    @DisplayName("If the distance of the first restaurant is equal to the distance of the second restaurant, then should return -1 if the rating of the first restaurant is greater than the rating of the second restaurant")
    void test03() {
        SortRestaurant sortRestaurant = new SortRestaurant();
        Restaurant restaurant1 = Restaurant.builder().name("Restaurant 1").price(10).id(UUID.randomUUID()).rating(3).distance(10).cuisine(DomainHelper.createCuisine()).build();
        Restaurant restaurant2 = Restaurant.builder().name("Restaurant 2").price(20).id(UUID.randomUUID()).rating(2).distance(10).cuisine(DomainHelper.createCuisine()).build();

        int result = sortRestaurant.compare(restaurant1, restaurant2);

        assertEquals(-1, result);
    }

    @Test
    @DisplayName("If the distance of the first restaurant is equal to the distance of the second restaurant, then should return 1 if the rating of the first restaurant is less than the rating of the second restaurant")
    void test04() {
        SortRestaurant sortRestaurant = new SortRestaurant();
        Restaurant restaurant1 = Restaurant.builder().name("Restaurant 1").price(10).id(UUID.randomUUID()).rating(2).distance(10).cuisine(DomainHelper.createCuisine()).build();
        Restaurant restaurant2 = Restaurant.builder().name("Restaurant 2").price(20).id(UUID.randomUUID()).rating(3).distance(10).cuisine(DomainHelper.createCuisine()).build();

        int result = sortRestaurant.compare(restaurant1, restaurant2);

        assertEquals(1, result);
    }

    @Test
    @DisplayName("If the distance and the rating of the first restaurant are equal to the distance and the rating of the second restaurant, then sould return -1 if the price of the first restaurant is less than the price of the second restaurant")
    void test05() {
        SortRestaurant sortRestaurant = new SortRestaurant();
        Restaurant restaurant1 = Restaurant.builder().name("Restaurant 1").price(10).id(UUID.randomUUID()).rating(2).distance(10).cuisine(DomainHelper.createCuisine()).build();
        Restaurant restaurant2 = Restaurant.builder().name("Restaurant 2").price(20).id(UUID.randomUUID()).rating(2).distance(10).cuisine(DomainHelper.createCuisine()).build();

        int result = sortRestaurant.compare(restaurant1, restaurant2);

        Assertions.assertEquals(-1, result);
    }

}