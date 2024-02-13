package com.alphasights.restaurant.adapters.persistence.csv;

import com.alphasights.restaurant.domain.entity.Cuisine;
import com.alphasights.restaurant.domain.entity.Restaurant;
import com.alphasights.restaurant.domain.ports.SearchAllRestaurantsPort;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@RequiredArgsConstructor
@Slf4j
public class RestaurantsCSVRepository implements SearchAllRestaurantsPort {
    private final String restaurantCSVFilePath;
    private final String cuisineCSVFilePath;

    private final List<Restaurant> restaurants = new ArrayList<>();
    private final Map<Integer, Cuisine> cuisineMap = new HashMap<>();

    @PostConstruct
    public void init() {
        try {
            loadCuisines();
            loadRestaurants();
        } catch (IOException | CsvValidationException e) {
            log.error("Error loading restaurants", e);
        }
    }

    private void loadRestaurants() throws IOException, CsvValidationException {
        try (CSVReader csvReader = new CSVReader(new FileReader(ResourceUtils.getFile(restaurantCSVFilePath)));) {
            String[] values;
            csvReader.readNext(); // skip header
            while ((values = csvReader.readNext()) != null) {
                this.restaurants.add(
                        Restaurant.builder()
                                .id(UUID.randomUUID())
                                .name(values[0])
                                .rating(Integer.parseInt(values[1]))
                                .distance(Integer.parseInt(values[2]))
                                .price(Integer.parseInt(values[3]))
                                .cuisine(this.cuisineMap.get(Integer.parseInt(values[4])))
                                .build()
                );
            }
        }
    }


    private void loadCuisines() throws IOException, CsvValidationException {
        try (CSVReader csvReader = new CSVReader(new FileReader(ResourceUtils.getFile(cuisineCSVFilePath)));) {
            String[] values;
            csvReader.readNext(); // skip header
            while ((values = csvReader.readNext()) != null) {
                Integer cuisineId = Integer.parseInt(values[0]);
                String cuisineName = values[1];

                this.cuisineMap.put(cuisineId, new Cuisine(cuisineId, cuisineName));
            }
        }
    }

    @Override
    public List<Restaurant> getRestaurants() {
        return this.restaurants;
    }
}
