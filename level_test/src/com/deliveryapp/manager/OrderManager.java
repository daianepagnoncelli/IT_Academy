package com.deliveryapp.manager;

import com.deliveryapp.exception.NoDeliveryPersonAvailableException;
import com.deliveryapp.exception.OrderNotFoundException;
import com.deliveryapp.model.Customer;
import com.deliveryapp.model.CustomerOrder;
import com.deliveryapp.model.DeliveryPerson;
import com.deliveryapp.model.Order;
import com.deliveryapp.model.product.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class OrderManager {
    private final List<CustomerOrder> orders = new ArrayList<>();

    public void createOrder(Customer customer, List<Product> products) throws NoDeliveryPersonAvailableException {
        DeliveryPerson deliveryPerson = DeliveryPerson.selectRandomAvailable();
        if (deliveryPerson == null) {
            throw new NoDeliveryPersonAvailableException("No delivery guys available.");
        }
        Order order = new Order(customer, products, deliveryPerson);
        deliveryPerson.setAvailable(false);
        orders.add( new CustomerOrder(customer, order));
        order.showDetails();
    }

    public void markOrderAsDelivered(int orderId) {
        Optional<CustomerOrder> optionalCustomerOrder = orders.stream()
                .filter(co -> co.getOrder().getId() == orderId && !co.getOrder().isDelivered())
                .findFirst();

        if (optionalCustomerOrder.isPresent()) {
            CustomerOrder customerOrder = optionalCustomerOrder.get();
            customerOrder.getOrder().setDelivered(true);
            customerOrder.getOrder().getDeliveryPerson().setAvailable(true);
            System.out.println("Order " + orderId + " marked as delivered.");
        } else {
            throw new OrderNotFoundException("Order not found or already delivered.");
        }
    }

    public void listPendingOrders() {
        Optional<CustomerOrder> anyPendingOrder = orders.stream()
                .filter(co -> !co.getOrder().isDelivered())
                .findAny();

        if (anyPendingOrder.isPresent()) {
            System.out.println("Pending orders:");
            orders.stream()
                    .filter(co -> !co.getOrder().isDelivered())
                    .forEach(CustomerOrder::showDetails);
        } else {
            System.out.println("No pending orders");
        }
    }

    public void listDeliveredOrders() {
        List<CustomerOrder> deliveredOrders = orders.stream()
                .filter(co -> co.getOrder().isDelivered())
                .toList();

        if (!deliveredOrders.isEmpty()) {
            System.out.println("Delivered orders:");
            deliveredOrders.forEach(CustomerOrder::showDetails);
        } else {
            System.out.println("No delivered orders.");
        }
    }
}

