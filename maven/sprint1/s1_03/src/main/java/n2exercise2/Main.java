package n2exercise2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashSet<Restaurant> restaurantSet = new HashSet<>();

        restaurantSet.add(new Restaurant("Restaurant B", 3));
        restaurantSet.add(new Restaurant("Restaurant A", 4));
        restaurantSet.add(new Restaurant("Restaurant A", 4)); // adding a similar restaurant

        RestaurantManager manager = new RestaurantManager();
        manager.displayRestaurantsSortedByName(restaurantSet);
        manager.displayRestaurantsSortedByScore(restaurantSet);
    }
}


