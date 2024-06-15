package itacademy.n2exercise1.shoeshop;

import itacademy.n2exercise1.payment.*;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);
    static ShoeShop shoeShop = new ShoeShop();

    static {
        initializeStock(shoeShop);
    }

    public static void main(String[] args) {
        menuDisplay();
    }

    private static void menuDisplay() {
        int option;
        String message;
        do {
            option = inputInt("""
                    Select an option:
                    0. Exit
                    1. Pay
                    """);
            if (option == 0) {
                message = "Goodbye!";
            } else if (option == 1) {
                message = payBasket(shoeShop.getBasket());
            } else {
                message = "Invalid option. Please try again.";
            }
            System.out.println(message);
        } while (option != 0);
    }

    private static String payBasket(List<Shoe> basket) {
        double total = shoeShop.calculateTotal();
        String message = "";
        int paymentMethodOption;

        if (!basket.isEmpty()) {
            do {
                paymentMethodOption = inputInt("""
                        Select the payment method option:
                        0. Exit
                        1. Bank Account
                        2. Credit Card
                        3. PayPal
                        """);
                switch (paymentMethodOption) {
                    case 0:
                        message = "The items will be kept in the basket for future payment.";
                        break;
                    case 1:
                        String IBAN = inputString("Enter your IBAN number: ");
                        shoeShop.buyShoes(new BankAccountPayment(IBAN, total), total);
                        message = "The payment of " + total + " € has been deducted from account no. " + IBAN;
                        break;
                    case 2:
                        String cardNumber = inputString("Enter your credit card number: ");
                        shoeShop.buyShoes(new CreditCardPayment(cardNumber, total), total);
                        message = "The payment of " + total + " € has been charged to credit card no. " + cardNumber;
                        break;
                    case 3:
                        String accountName = inputString("Enter your PayPal account name: ");
                        shoeShop.buyShoes(new PayPalPayment(accountName, total), total);
                        message = "PayPal payment to account " + accountName + " of " + total + " € has been executed correctly.";
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid payment method option.");
                }
            } while (paymentMethodOption != 0);
        } else {
            message = "The basket is empty. There must be some items in the basket to pay.";
        }

        return message;
    }

    private static void initializeStock(ShoeShop shoeShop) {
        shoeShop.addShoe(new Shoe("Samba", "Adidas", 69.90));
        shoeShop.addShoe(new Shoe("Stan Smith", "Adidas", 64.95));
        shoeShop.addShoe(new Shoe("Camp", "Camper", 125.95));
    }

    private static int inputInt(String prompt) {
        int input = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.println(prompt);
            try {
                input = scanner.nextInt();
                isValid = true;
            } catch (InputMismatchException e) {
                System.err.println("Format Error. Please enter a valid integer.");
            } finally {
                scanner.nextLine();
            }
        }
        return input;
    }

    private static String inputString(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }
}
