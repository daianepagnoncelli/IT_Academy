package n2exercise2;

import java.util.*;

public class RestaurantManager {
    public void displayRestaurantsSortedByName(HashSet<Restaurant> restaurantSet) {
        List<Restaurant> sortedByName = new ArrayList<>(restaurantSet);
        sortedByName.sort(Comparator.comparing(Restaurant::getName));
        System.out.println("Sorted by name:");
        for (Restaurant restaurant : sortedByName) {
            System.out.println("Name: " + restaurant.getName() + ", Score: " + restaurant.getScore());
        }
    }

    public void displayRestaurantsSortedByScore(HashSet<Restaurant> restaurantSet) {
        List<Restaurant> sortedByScore = new ArrayList<>(restaurantSet);
        sortedByScore.sort(Comparator.comparingInt(Restaurant::getScore));
        System.out.println("Sorted by score:");
        for (Restaurant restaurant : sortedByScore) {
            System.out.println("Name: " + restaurant.getName() + ", Score: " + restaurant.getScore());
        }
    }
}
