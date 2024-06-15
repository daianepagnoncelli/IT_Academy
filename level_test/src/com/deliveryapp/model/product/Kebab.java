package com.deliveryapp.model.product;

public class Kebab extends Product {
    public Kebab() {
        super("Kebab", 4.5);
    }

    @Override
    public void showGift() {
        System.out.println("  -> NO GIFT");
    }
}

