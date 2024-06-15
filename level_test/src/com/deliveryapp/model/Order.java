package com.deliveryapp.model;

import com.deliveryapp.model.product.Product;

import java.text.DecimalFormat;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Order {
    private static final AtomicInteger counter = new AtomicInteger(0);

    private final int id;
    private final Customer customer;
    private final List<Product> products;
    private final DeliveryPerson deliveryGuy;
    private boolean delivered;

    public Order(Customer customer, List<Product> products, DeliveryPerson deliveryGuy) {
        if (customer == null || products == null || products.isEmpty()) {
            throw new IllegalArgumentException("The order must have a customer and at least one product.");
        }
        this.id = counter.incrementAndGet();
        this.customer = customer;
        this.products = products;
        this.deliveryGuy = deliveryGuy;
        this.delivered = false;
    }

    public int getId() {
        return id;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public DeliveryPerson getDeliveryPerson() {
        return deliveryGuy;
    }

    public double calculateTotal() {
        double total = products.stream().mapToDouble(Product::getPrice).sum();
        double additionalCost = total * calculateAdditionalCost();
        return total + additionalCost;
    }

    public double calculateAdditionalCost() {
        return switch (deliveryGuy) {
            case NICO, JAYDEN -> 0.02;
            case TIAGO -> 0.01;
        };
    }

    public void showDetails() {
        System.out.println("*******************************");
        System.out.println("Order ID: " + id);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Address: " + customer.getAddress());
        System.out.println("Delivery Person: " + deliveryGuy.getName());
        System.out.println("Products:        ");
        for (Product product : products) {
            System.out.println("- " + product.getName() + ": " + product.getPrice() + "€");
            product.showGift();
        }
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("Total: " + df.format(calculateTotal()) + "€");
        System.out.println("*******************************");
    }
}
