package com.deliveryapp;

import com.deliveryapp.exception.NoDeliveryPersonAvailableException;
import com.deliveryapp.exception.OrderNotFoundException;
import com.deliveryapp.manager.OrderManager;
import com.deliveryapp.model.Customer;
import com.deliveryapp.model.product.Product;
import com.deliveryapp.model.product.ProductType;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderApp {
    private final OrderManager manager;

    public OrderApp() {
        this.manager = new OrderManager();
    }

    public void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\nOptions:");
                System.out.println("1. Create a new order");
                System.out.println("2. Mark an order as delivered");
                System.out.println("3. List pending orders");
                System.out.println("4. List delivered orders");
                System.out.println("5. Exit");
                System.out.print("\nSelect an option: ");

                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1 -> createNewOrder(scanner);
                    case 2 -> markOrderAsDelivered(scanner);
                    case 3 -> manager.listPendingOrders();
                    case 4 -> manager.listDeliveredOrders();
                    case 5 -> {
                        System.out.println("Exiting the system...");
                        return;
                    }
                    default -> System.out.println("Invalid option.");
                }
            }
        }
    }

    private void createNewOrder(Scanner scanner) {
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine().trim();
        System.out.print("Enter customer address: ");
        String customerAddress = scanner.nextLine().trim();

        Customer customer = new Customer(customerName, customerAddress);

        System.out.println("Available products:");
        for (int i = 0; i < ProductType.values().length; i++) {
            System.out.println((i + 1) + ". " + ProductType.values()[i].getProductName());
        }

        List<Product> selectedProducts = new ArrayList<>();
        boolean addingProducts = true;
        while (addingProducts) {
            System.out.print("Select a product (enter its number): ");
            int productNumber = scanner.nextInt();
            scanner.nextLine();

            if (productNumber < 1 || productNumber > ProductType.values().length) {
                System.out.println("Invalid product number. Please try again.");
                continue;
            }

            ProductType selectedProductType = ProductType.values()[productNumber - 1];
            Product selectedProduct = selectedProductType.createProduct();
            selectedProducts.add(selectedProduct);

            System.out.print("Do you want to add another product? (yes/no): ");
            String choice = scanner.nextLine();

            addingProducts = choice.equalsIgnoreCase("yes");
        }

        try {
            manager.createOrder(customer, selectedProducts);
            System.out.println("Order created successfully!");
        } catch (NoDeliveryPersonAvailableException e) {
            System.out.println(e.getMessage());
        }
    }


    private void markOrderAsDelivered(Scanner scanner) {
        System.out.print("Enter order ID to mark as delivered: ");
        int orderId = scanner.nextInt();
        scanner.nextLine();

        try {
            manager.markOrderAsDelivered(orderId);
            System.out.println("Order marked as delivered successfully!");
        } catch (OrderNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

