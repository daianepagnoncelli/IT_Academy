package n2exercise1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Smartphone smartphone = new Smartphone("Apple", "IPhone 14Pro");
        smartphone.photograph();
        smartphone.alarm();

        System.out.print("Enter a phone number to call: ");
        String phoneNumber = scanner.nextLine();
        smartphone.call(phoneNumber);

        scanner.close();
    }
}

