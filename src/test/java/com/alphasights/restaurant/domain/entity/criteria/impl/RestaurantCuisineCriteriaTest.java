package com.alphasights.restaurant.domain.entity.criteria.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantCuisineCriteriaTest {
    RestaurantCuisineCriteria sut = new RestaurantCuisineCriteria();

    @Test
    @DisplayName("Should return true when restaurant cuisine is null")
    void test01() {
        RestaurantCuisineCriteria restaurantCuisineCriteria = new RestaurantCuisineCriteria();
        assertTrue(restaurantCuisineCriteria.belongs(null, null));
    }
    

}