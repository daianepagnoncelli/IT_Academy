package n2exercise1;

import n2exercise1.address.IAddress;
import n2exercise1.factory.BRContactFactory;
import n2exercise1.factory.ESContactFactory;
import n2exercise1.factory.IContactFactory;
import n2exercise1.phonenumber.IPhoneNumber;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Pattern;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Pattern;

public class AppTools {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Contact> AddressBook = new ArrayList<>();

    public static void displayMenu() {
        int option;
        String name;
        int contactIndex;
        String country;
        IContactFactory contactFactory = null;

        do {
            option = inputInt("""
                    Select an option:
                    0. Exit
                    1. Create contact
                    2. Show contact
                    3. Delete contact
                    4. List address book
                    """);

            switch (option) {
                case 0:
                    System.out.println("Goodbye!");
                    break;
                case 1:
                    name = inputString("Enter the contact's name: ");
                    String[] addressData = requestAddressData();
                    country = addressData[7];

                    String phoneNumber = requestPhoneData(country);
                    if (country.equalsIgnoreCase("Spain")) {
                        contactFactory = new ESContactFactory();
                    } else if (country.equalsIgnoreCase("Brazil")) {
                        contactFactory = new BRContactFactory();
                    } else {
                        System.out.println("Error! Address book for this country has not been created.");
                    }
                    IAddress newAddress = contactFactory.createAddress(addressData);
                    IPhoneNumber newPhoneNumber = contactFactory.createPhoneNumber(phoneNumber);
                    AddressBook.add(new Contact(name, country, newAddress, newPhoneNumber));
                    break;
                case 2:
                    if (AddressBook.size() > 0) {
                        System.out.println(listAddressBookNames());
                        do {
                            name = inputString("Enter the name of the contact to show: ");
                            contactIndex = getContactIndex(name);
                            if (contactIndex != -1) {
                                System.out.println(AddressBook.get(contactIndex).toString());
                            } else {
                                System.out.println("This contact does not exist.");
                            }
                        } while (contactIndex == -1);
                    } else {
                        System.out.println("The address book is empty.");
                    }
                    break;
                case 3:
                    if (AddressBook.size() > 0) {
                        System.out.println(listAddressBookNames());
                        do {
                            name = inputString("Enter the name of the contact to delete: ");
                            contactIndex = getContactIndex(name);
                            if (contactIndex != -1) {
                                AddressBook.remove(contactIndex);
                                System.out.println("The contact " + name + " has been deleted.");
                            } else {
                                System.out.println("This contact does not exist.");
                            }
                        } while (contactIndex == -1);
                    } else {
                        System.out.println("The address book is empty.");
                    }
                    break;
                case 4:
                    if (AddressBook.size() > 0) {
                        AddressBook.sort(
                                (Contact c1, Contact c2) -> c1.compareTo(c2));
                        for (Contact c: AddressBook) {
                            System.out.println(c.toString());
                        }
                    } else {
                        System.out.println("The address book is empty.");
                    }
                    break;
            }
        } while (option != 0);
    }

    public static String[] requestAddressData() {
        final String street = inputString("Street name: ");
        final String streetNumber = inputString("Street number: ");
        final String floorNumber = (inputBoolean("Do you have a floor number (yes or no)? ")) ? inputString("Floor number: ") : "";
        final String doorNumber = (inputBoolean("Do you have an apartment number (yes or no)? ")) ? inputString("Apartment number: ") : "";
        final String cityTown = inputString("City or Town: ");
        final String province = inputString("State or Province: ");
        Optional<Country> found;
        String country;
        do {
            country = inputString("Country (Spain, Brazil): ");
            found = Country.findByValue(country);
        } while (!found.isPresent());
        final String postCode = requestPostCode(country);
        return new String[] {street, streetNumber, floorNumber, doorNumber, cityTown, province, postCode, country};
    }

    public static String requestPostCode(String country) {
        String postCode;
        final String regexPostCode = Country.valueOf(country).getRegexPostCode();
        boolean matches;
        do {
            postCode = inputString("Postcode: ");
            matches = Pattern.compile(regexPostCode).matcher(postCode).matches();
        } while(!matches);
        return postCode;
    }

    public static String requestPhoneData(String country) {
        String phoneNumber;
        final String regexPhone = Country.valueOf(country).getRegexPhoneNumber();
        boolean matches;
        do {
            phoneNumber = inputString("Phone number: ");
            matches = Pattern.matches(regexPhone, phoneNumber);
            if (!matches) {
                System.out.println("Invalid phone number for " + country);
            }
        } while(!matches);
        return phoneNumber;
    }

    // Placeholder methods to avoid errors in the provided code snippet
    private static String inputString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private static int inputInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. " + prompt);
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static boolean inputBoolean(String prompt) {
        System.out.print(prompt);
        String response = scanner.nextLine().trim().toLowerCase();
        return response.equals("yes");
    }

    private static String listAddressBookNames() {
        StringBuilder names = new StringBuilder();
        for (Contact contact : AddressBook) {
            names.append(contact.getName()).append("\n");
        }
        return names.toString();
    }

    private static int getContactIndex(String name) {
        for (int i = 0; i < AddressBook.size(); i++) {
            if (AddressBook.get(i).getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }
}
