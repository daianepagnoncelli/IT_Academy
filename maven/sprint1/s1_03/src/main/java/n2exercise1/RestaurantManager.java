package n2exercise1;

import java.util.HashSet;

public class RestaurantManager {
    public void displayRestaurants(HashSet<Restaurant> restaurantSet) {
        for (Restaurant restaurant : restaurantSet) {
            System.out.println("Name: " + restaurant.getName() + ", Score: " + restaurant.getScore());
        }
    }
}
