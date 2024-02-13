package com.alphasights.restaurant.domain.usecases;

import com.alphasights.restaurant.domain.entity.Cuisine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CuisineTest {

    @Test
    @DisplayName("Should throw IllegalArgumentException when name is null")
    void test01() {
        assertThrows(IllegalArgumentException.class, () -> new Cuisine(1, null));
    }

}