package com.deliveryapp.model.product;

public class Pizza extends Product {
    public Pizza() {
        super("Pizza", 12.0);
    }

    @Override
    public void showGift() {
        System.out.println("  -> Free gift: Garlic Bread");
    }
}

