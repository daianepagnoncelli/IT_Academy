package n2exercise2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RestaurantManager manager = new RestaurantManager();

        manager.addRestaurant("Pizza Paradise", 5);
        manager.addRestaurant("Burger Bistro", 4);
        manager.addRestaurant("Taco Temple", 5);
        manager.addRestaurant("Noodle Nirvana", 4);

        while (true) {
            System.out.println("\nChoose sorting order:");
            System.out.println("1. Sort by name");
            System.out.println("2. Sort by score");
            System.out.print("Enter your choice (1 or 2): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                manager.printRestaurantsByName();
            } else if (choice == 2) {
                manager.printRestaurantsByScore();
            } else {
                System.out.println("Invalid choice. Please enter 1 or 2.");
            }

            System.out.print("\nDo you want to sort again? (y/n): ");
            String answer = scanner.nextLine().toLowerCase();
            if (!answer.equals("y")) {
                break;
            }
        }

        scanner.close();
    }
}





