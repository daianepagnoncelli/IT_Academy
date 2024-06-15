package com.deliveryapp.model;

public class CustomerOrder {
    private final Customer customer;
    private final Order order;

    public CustomerOrder(Customer customer, Order order) {
        this.customer = customer;
        this.order = order;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Order getOrder() {
        return order;
    }

    public void showDetails() {
        order.showDetails();
    }
}




