package com.deliveryapp.manager;

import com.deliveryapp.exception.NoDeliveryPersonAvailableException;
import com.deliveryapp.exception.OrderNotFoundException;
import com.deliveryapp.model.Customer;
import com.deliveryapp.model.DeliveryPerson;
import com.deliveryapp.model.Order;
import com.deliveryapp.model.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OrderManager {
    private final List<Order> orders = new ArrayList<>();
    private final List<DeliveryPerson> deliveryPersons;

    public OrderManager(List<DeliveryPerson> deliveryPersons) {
        this.deliveryPersons = deliveryPersons;
    }

    public void createOrder(Customer customer, List<Product> products) {
        DeliveryPerson deliveryPerson = getAvailableDeliveryPerson();
        Order order = new Order(customer, products, deliveryPerson);
        deliveryPerson.setAvailable(false);
        orders.add(order);
        order.showDetails();
    }

    public void markOrderAsDelivered(int orderId) {
        Order order = orders.stream()
                .filter(o -> o.getId() == orderId && !o.isDelivered())
                .findFirst()
                .orElseThrow(() -> new OrderNotFoundException("Order not found or already delivered."));
        order.setDelivered(true);
        order.getDeliveryPerson().setAvailable(true);
        System.out.println("Order " + orderId + " marked as delivered.");
    }

    public void listPendingOrders() {
        System.out.println("Pending orders:");
        orders.stream().filter(o -> !o.isDelivered()).forEach(Order::showDetails);
    }

    public void listDeliveredOrders() {
        System.out.println("Delivered orders:");
        orders.stream().filter(Order::isDelivered).forEach(Order::showDetails);
    }

    private DeliveryPerson getAvailableDeliveryPerson() {
        List<DeliveryPerson> available = deliveryPersons.stream()
                .filter(DeliveryPerson::isAvailable)
                .toList();
        if (available.isEmpty()) {
            throw new NoDeliveryPersonAvailableException("No delivery persons available.");
        }
        return available.get(new Random().nextInt(available.size()));
    }
}
