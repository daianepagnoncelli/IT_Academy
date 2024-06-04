package com.deliveryapp.model.product;

public class Burger extends Product {
    public Burger() {
        super("Burger", 8.0);
    }

    @Override
    public void showGift() {
        System.out.println("  -> Free gift: Soda");
    }
}

