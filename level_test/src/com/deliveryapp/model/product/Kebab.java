package com.deliveryapp.model.product;

public class Kebab extends Product {
    public Kebab() {
        super("Kebab", 5.0);
    }

    @Override
    public void showGift() {
        System.out.println("  -> Free gift: Extra Tzatziki");
    }
}

