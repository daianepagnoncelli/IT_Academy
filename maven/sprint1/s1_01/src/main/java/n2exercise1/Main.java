package n2exercise1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Getting phone make and model from the user
        System.out.println("Enter phone make: ");
        String make = scanner.nextLine();
        System.out.println("Enter phone model: ");
        String model = scanner.nextLine();

        // Creating Smartphone object
        Smartphone smartphone = new Smartphone(make, model);

        // Calling methods
        smartphone.call("123-456-7890");
        smartphone.photograph();
        smartphone.alarm();

        scanner.close();
    }
}
