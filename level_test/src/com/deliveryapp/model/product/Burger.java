package com.deliveryapp.model.product;

public class Burger extends Product {
    public Burger() {
        super("Burger", 8.9);
    }

    @Override
    public void showGift() {
        System.out.println("  -> Free gift: Cap");
    }
}


