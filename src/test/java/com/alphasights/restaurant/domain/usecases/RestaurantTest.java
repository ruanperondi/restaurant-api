package com.alphasights.restaurant.domain.usecases;

import com.alphasights.restaurant.domain.entity.Cuisine;
import com.alphasights.restaurant.domain.entity.Restaurant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class RestaurantTest {

    @Test
    @DisplayName("Should throw IllegalArgumentException when name is null")
    void test01() {
        assertThrows(IllegalArgumentException.class, () -> Restaurant.builder().build());
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when rating is null")
    void test02() {
        assertThrows(IllegalArgumentException.class, () -> Restaurant.builder().name("name").build());
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when rating is less than 0")
    void test03() {
        assertThrows(IllegalArgumentException.class, () -> Restaurant.builder().name("name").rating(-1).build());
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when rating is greater than 5")
    void test04() {
        assertThrows(IllegalArgumentException.class, () -> Restaurant.builder().name("name").rating(6).build());
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when distance is null")
    void test05() {
        assertThrows(IllegalArgumentException.class, () -> Restaurant.builder().name("name").rating(3).build());
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when distance is less than 0")
    void test06() {
        assertThrows(IllegalArgumentException.class, () -> Restaurant.builder().name("name").rating(3).distance(-1).build());
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when price is null")
    void test07() {
        assertThrows(IllegalArgumentException.class, () -> Restaurant.builder().name("name").rating(3).distance(1).build());
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when price is less than 0")
    void test08() {
        assertThrows(IllegalArgumentException.class, () -> Restaurant.builder().name("name").rating(3).distance(1).price(-1).build());
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when cuisine is null")
    void test09() {
        assertThrows(IllegalArgumentException.class, () -> Restaurant.builder().name("name").rating(3).distance(1).price(1).build());
    }

    @Test
    @DisplayName("Should generate an ID if not provided")
    void test10() {
        Restaurant restaurant = Restaurant.builder().name("name").rating(3).distance(1).price(1).cuisine(new Cuisine(1, "Chinese")).build();
        assert restaurant.getId() != null;
    }
}