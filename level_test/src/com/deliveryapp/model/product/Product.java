package com.deliveryapp.model.product;

public abstract class Product {
    protected final String name;
    protected final double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public abstract void showGift();
}

