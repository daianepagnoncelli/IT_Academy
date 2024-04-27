package n2exercise2;

import java.util.*;

public class RestaurantManager {

    private final HashSet<Restaurant> restaurants;

    public RestaurantManager() {
        this.restaurants = new HashSet<>();
    }

    public void addRestaurant(String name, int score) {
        Restaurant restaurant = new Restaurant(name, score);
        restaurants.add(restaurant);
    }

    public void printRestaurantsByName() {
        TreeSet<Restaurant> sortedByName = new TreeSet<>(restaurants);
        for (Restaurant restaurant : sortedByName) {
            System.out.println(restaurant);
        }
    }

    public void printRestaurantsByScore() {
        TreeSet<Restaurant> sortedRestaurants = new TreeSet<>(restaurants);
        for (Restaurant restaurant : sortedRestaurants) {
            System.out.println(restaurant);
        }
    }
}

