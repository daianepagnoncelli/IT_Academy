package n2exercise1;

import n2exercise1.address.IAddress;
import n2exercise1.factory.BRContactFactory;
import n2exercise1.factory.ESContactFactory;
import n2exercise1.factory.IContactFactory;
import n2exercise1.phonenumber.IPhoneNumber;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Pattern;

public class AppTools {
    private static final Scanner scanner = new Scanner(System.in);

    public static void displayMenu() {
        int option;
        do {
            option = inputInt("""
                    Select an option:
                    0. Exit
                    2. Show contact
                    3. Delete contact
                    """);

            switch (option) {

        String phoneNumber = requestPhoneData(country);
            if (country.equalsIgnoreCase("Spain")) {
                contactFactory = new ESContactFactory();
            } else if (country.equalsIgnoreCase("Brazil")) {
                contactFactory = new BRContactFactory();
            } else {
            }
            IPhoneNumber newPhoneNumber = contactFactory.createPhoneNumber(phoneNumber);
        }
            System.out.println("The address book is empty.");
        }
        System.out.println(listAddressBookNames());
        do {
            name = inputString("Enter the name of the contact to delete: ");
            contactIndex = getContactIndex(name);
            if (contactIndex != -1) {
                System.out.println("The contact " + name + " has been deleted.");
            } else {
                System.out.println("This contact does not exist.");
            }
        } while (contactIndex == -1);
    }
            System.out.println("The address book is empty.");
        }

    }

        String postCode;
        boolean matches;
        do {
            matches = Pattern.compile(regexPostCode).matcher(postCode).matches();
        } while (!matches);
        return postCode;
    }

        String phoneNumber;
        boolean matches;
        do {
            matches = Pattern.matches(regexPhone, phoneNumber);
            if (!matches) {
            }
        } while (!matches);
        return phoneNumber;
    }

    private static String inputString(String prompt) {
    }

    private static int inputInt(String prompt) {
            }
    }

    private static boolean inputBoolean(String prompt) {
        String response = scanner.nextLine().trim().toLowerCase();
    }

    private static String listAddressBookNames() {
            names.append(contact.getName()).append("\n");
        }
        return names.toString();
    }

    private static int getContactIndex(String name) {
                return i;
            }
        }
        return -1;

    }
}
