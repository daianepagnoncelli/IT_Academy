package n2exercise1;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<Restaurant> restaurantSet = new HashSet<>();

        restaurantSet.add(new Restaurant("Restaurant A", 4));
        restaurantSet.add(new Restaurant("Restaurant B", 3));
        restaurantSet.add(new Restaurant("Restaurant A", 4));
        restaurantSet.add(new Restaurant("Restaurant B", 2));
        restaurantSet.add(new Restaurant("Restaurant B", 2));

        RestaurantManager manager = new RestaurantManager();
        manager.displayRestaurants(restaurantSet);
    }
}