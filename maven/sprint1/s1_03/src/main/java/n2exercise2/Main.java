package n2exercise2;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Restaurant> restaurantSet = new TreeSet<>();

        // Add restaurants TreeSet
        restaurantSet.add(new Restaurant("Restaurant B", 3));
        restaurantSet.add(new Restaurant("Restaurant A", 4));
        restaurantSet.add(new Restaurant("Restaurant A", 3));
        restaurantSet.add(new Restaurant("Restaurant B", 4));

        // sorted
        for (Restaurant restaurant : restaurantSet) {
            System.out.println("Name: " + restaurant.getName() + ", Score: " + restaurant.getScore());
        }
    }
}
