package n2exercise1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose country (USA/UK): ");
        String country = scanner.nextLine().toUpperCase();

        ContactFactory factory;
        switch (country) {
            case "USA":
                factory = new USAContactFactory();
                break;
            case "UK":
                factory = new UKContactFactory();
                break;
            default:
                System.out.println("Unsupported country.");
                scanner.close();
                return;
        }

        System.out.println("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        PhoneNumber phone = factory.createPhoneNumber(phoneNumber);
        System.out.println("Formatted phone number: " + phone.getFormattedPhoneNumber());

        System.out.println("Enter street: ");
        String street = scanner.nextLine();
        System.out.println("Enter city: ");
        String city = scanner.nextLine();
        System.out.println("Enter postal code: ");
        String postalCode = scanner.nextLine();
        Address address = factory.createAddress(street, city, postalCode);
        System.out.println("Formatted address: " + address.getFormattedAddress());

        scanner.close();
    }
}

