# Restaurant API

### Reference Documentation
This application uses Hexagonal Architecture as base of develop.
Main Packages:
    - Application: Contains the main class and the configuration of the application.
    - Domain: Contains the business logic of the application.
        - Entity: Contains the entities of the application.
            - Comparator: Contains the comparators of the entities.
            - Criteria: Contains the criteria of filters of retaurants
        - UseCase: Contains the use cases of the application.
        - Ports: Contains the interfaces of the application.
    - Adapters: Contains the implementation of the interfaces defined in the domain package.    
        - Persistence: Contains the implementation of the repositories.
        - Rest: Contains the implementation of the controllers and the configuration of the web layer.

* [Hexagonal Achitecture](https://miro.medium.com/v2/resize:fill:1200:900/g:fp:0.49:0.49/1*NfFzI7Z-E3ypn8ahESbDzw.png)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.2/maven-plugin/reference/html/)

### Run
To run the application, you need to execute the following command:
Import the project in your favorite IDE and run the class `RestaurantApplication`

### Test
You can test using the following api:
* [GET /restaurants](http://localhost:8080/restaurants) - Get all restaurants
* [GET /restaurants?name=restaurantName](http://localhost:8080/restaurants?name=restaurantName) - Get all restaurants by name
* [GET /restaurants?rating=restaurantRating](http://localhost:8080/restaurants?rating=restaurantRating) - Get all restaurants by 
* [GET /restaurants?distance=restaurantDistance](http://localhost:8080/restaurants?distance=restaurantDistance) - Get all restaurants by distance
* [GET /restaurants?cuisine=restaurantCuisine](http://localhost:8080/restaurants?cuisine=restaurantCuisine) - Get all restaurants by cuisine
* [GET /restaurants?name=restaurantName&rating=restaurantRating&distance=restaurantDistance&cuisine=restaurantCuisine](http://localhost:8080/restaurants?name=restaurantName&rating=restaurantRating&distance=restaurantDistance&cuisine=restaurantCuisine) - Get all restaurants by name, rating, distance and cuisine