package itacademy.n2exercise1.shoeshop;

import itacademy.n2exercise1.payment.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ShoeShop shoeShop = new ShoeShop();
    private static final List<Shoe> basket = new ArrayList<>();

    static {
        initializeStock(shoeShop);
    }

    public static void main(String[] args) {
        menuDisplay();
    }

    private static void initializeStock(ShoeShop shoeShop) {
        shoeShop.addShoe(new Shoe("Samba", "Nike", 79.99));
        shoeShop.addShoe(new Shoe("Air Force 1", "Nike", 89.95));
        shoeShop.addShoe(new Shoe("Old Skool", "Vans", 59.99));
    }

    public static void menuDisplay() {
        int option;
        String message;
        do {
            option = inputInt("""
                    Select an option:
                    1. Add shoes to basket
                    2. Pay
                    0. Exit
                    """);
            switch (option) {
                case 0:
                    message = "Byebye!";
                    break;
                case 1:
                    basket.addAll(selectShoes());
                    message = "Shoes added to the basket.";
                    break;
                case 2:
                    if (!basket.isEmpty()) {
                        message = payBasket();
                        basket.clear();
                    } else {
                        message = "The basket is empty. Add shoes to the basket first.";
                    }
                    break;
                default:
                    message = "Invalid option. Please select again.";
                    break;
            }
            System.out.println(message);
        } while (option != 0);
    }

    private static String payBasket() {
        double totalAmount = calculateTotalAmount();
        int paymentMethodOption;
        String message;
        do {
            paymentMethodOption = inputInt("""
                    Select the payment method option:
                    0. Exit
                    1. Bank Account
                    2. Credit Card
                    3. PayPal
                    """);
            if (paymentMethodOption == 0) {
                message = "The items will be kept in the basket for future payment.";
            } else if (paymentMethodOption == 1) {
                message = shoeShop.buyShoes(new BankAccountPayment("IBAN ES15 0081 2705 7800 0811 1523"), totalAmount);
            } else if (paymentMethodOption == 2) {
                message = shoeShop.buyShoes(new CreditCardPayment("5402 0897 4583 2585"), totalAmount);
            } else if (paymentMethodOption == 3) {
                message = shoeShop.buyShoes(new PayPalPayment("juanpedro@technolink.com"), totalAmount);
            } else {
                message = "Invalid payment method option.";
            }
        } while (paymentMethodOption <= 0 || paymentMethodOption > 3);
        return message;
    }

    private static double calculateTotalAmount() {
        double totalAmount = 0;
        for (Shoe shoe : basket) {
            totalAmount += shoe.getPrice();
        }
        return totalAmount;
    }

    private static List<Shoe> selectShoes() {
        List<Shoe> selectedShoes = new ArrayList<>();
        String model, reply;
        boolean keepBuying;
        do {
            System.out.println(showShoes());
            model = inputString("Enter the model you want to buy: ");
            Shoe selectedShoe = findShoe(model);
            if (selectedShoe != null) {
                selectedShoes.add(selectedShoe);
            } else {
                System.out.println("This model does not exist.");
            }
            reply = inputString("Do you want to add more shoes in the basket (Y/N) ? ");
            keepBuying = reply.equalsIgnoreCase("Y");
        } while (keepBuying);
        return selectedShoes;
    }

    private static Shoe findShoe(String model) {
        for (Shoe shoe : shoeShop.getStock()) {
            if (shoe.getModel().equalsIgnoreCase(model)) {
                return shoe;
            }
        }
        return null;
    }

    private static int inputInt(String message) {
        int input = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.println(message);
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

    private static String inputString(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    private static String showShoes() {
        StringBuilder shoesStock = new StringBuilder();
        if (!shoeShop.getStock().isEmpty()) {
            for (Shoe shoe : shoeShop.getStock()) {
                shoesStock.append(shoe).append("\n");
            }
        } else {
            shoesStock.append("There are no shoes in the shop.");
        }
        return shoesStock.toString();
    }
}

