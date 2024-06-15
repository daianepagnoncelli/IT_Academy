package n2exercise1;

import n2exercise1.address.IAddress;
import n2exercise1.factory.BRContactFactory;
import n2exercise1.factory.ESContactFactory;
import n2exercise1.factory.IContactFactory;
import n2exercise1.phonenumber.IPhoneNumber;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Pattern;

public class AppTools {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Contact> addressBook = new ArrayList<>();

    public static void main(String[] args) {
        displayMenu();
    }

    public static void displayMenu() {
        int option;
        do {
            option = inputInt("""
                    Select an option:
                    0. Exit
                    1. New contact
                    2. Show contact
                    3. Delete contact
                    4. List contacts
                    """);

            switch (option) {
                case 0 -> System.out.println("Goodbye!");
                case 1 -> createContact();
                case 2 -> showContact();
                case 3 -> deleteContact();
                case 4 -> listAddressBook();
                default -> System.out.println("Invalid option. Please choose again.");
            }
        } while (option != 0);
    }

    private static void createContact() {
        System.out.println("Creating a new contact:");
        String name = inputString("Enter the contact's name: ");
        String street = inputString("Enter street name: ");
        String streetNumber = inputString("Enter street number: ");
        String floorNumber = inputBoolean("Do you have a floor number (yes or no)? ") ? inputString("Enter floor number: ") : "";
        String doorNumber = inputBoolean("Do you have an apartment number (yes or no)? ") ? inputString("Enter apartment number: ") : "";
        String cityTown = inputString("Enter city or town: ");
        String province = inputString("Enter state or province: ");

        String country;
        Optional<Country> found;
        do {
            country = inputString("Enter country (Spain, Brazil): ");
            found = Country.findByValue(country);
            if (found.isEmpty()) {
                System.out.println("Invalid country entered. Please enter either Spain or Brazil.");
            }
        } while (found.isEmpty());

        String postCode = requestPostCode(country);
        String phoneNumber = requestPhoneData(country);

        try {
            IContactFactory contactFactory;
            if (country.equalsIgnoreCase("Spain")) {
                contactFactory = new ESContactFactory();
            } else if (country.equalsIgnoreCase("Brazil")) {
                contactFactory = new BRContactFactory();
            } else {
                throw new IllegalArgumentException("Invalid country entered.");
            }

            IAddress newAddress = contactFactory.createAddress(new String[]{street, streetNumber, floorNumber, doorNumber, cityTown, province, postCode});
            IPhoneNumber newPhoneNumber = contactFactory.createPhoneNumber(phoneNumber);
            addressBook.add(new Contact(name, country, newAddress, newPhoneNumber));
            System.out.println("Contact added successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred while creating the contact. Please try again.");
        }
    }

    private static void showContact() {
        if (addressBook.isEmpty()) {
            System.out.println("The address book is empty.");
            return;
        }

        System.out.println("Listing all contacts:");
        addressBook.sort(Comparator.naturalOrder());
        for (Contact contact : addressBook) {
            System.out.println(contact);
        }
    }

    private static void deleteContact() {
        if (addressBook.isEmpty()) {
            System.out.println("The address book is empty.");
            return;
        }

        System.out.println("Deleting a contact:");
        System.out.println(listAddressBookNames());
        String name;
        int contactIndex;
        do {
            name = inputString("Enter the name of the contact to delete: ");
            contactIndex = getContactIndex(name);
            if (contactIndex != -1) {
                addressBook.remove(contactIndex);
                System.out.println("The contact " + name + " has been deleted.");
            } else {
                System.out.println("This contact does not exist.");
            }
        } while (contactIndex == -1);
    }

    private static void listAddressBook() {
        if (addressBook.isEmpty()) {
            System.out.println("The address book is empty.");
            return;
        }

        System.out.println("Listing all contacts:");
        addressBook.sort(Comparator.naturalOrder());
        for (Contact contact : addressBook) {
            System.out.println(contact);
        }
    }

    private static String requestPostCode(String country) {
        String postCode;
        final String regexPostCode = Country.findByValue(country).orElseThrow().getRegexPostCode();
        boolean matches;
        do {
            postCode = inputString("Enter postcode: ");
            matches = Pattern.compile(regexPostCode).matcher(postCode).matches();
            if (!matches) {
                System.out.println("Invalid postcode format for " + country + ". Please try again.");
            }
        } while (!matches);
        return postCode;
    }

    private static String requestPhoneData(String country) {
        String phoneNumber;
        final String regexPhone = Country.findByValue(country).orElseThrow().getRegexPhoneNumber();
        boolean matches;
        do {
            phoneNumber = inputString("Enter phone number: ");
            matches = Pattern.matches(regexPhone, phoneNumber);
            if (!matches) {
                System.out.println("Invalid phone number format for " + country + ". Please try again.");
            }
        } while (!matches);
        return phoneNumber;
    }

    private static String inputString(String prompt) {
        System.out.print(prompt + " ");
        return scanner.nextLine().trim();
    }

    private static int inputInt(String prompt) {
        while (true) {
            System.out.print(prompt + " ");
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                scanner.nextLine();  // Clear the buffer
                return input;
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();  // Clear the buffer
            }
        }
    }

    private static boolean inputBoolean(String prompt) {
        System.out.print(prompt + " ");
        String response = scanner.nextLine().trim().toLowerCase();
        return response.equals("yes") || response.equals("y");
    }

    private static String listAddressBookNames() {
        StringBuilder names = new StringBuilder("Contacts in Address Book:\n");
        for (Contact contact : addressBook) {
            names.append(contact.getName()).append("\n");
        }
        return names.toString();
    }

    private static int getContactIndex(String name) {
        for (int i = 0; i < addressBook.size(); i++) {
            if (addressBook.get(i).getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }
}

