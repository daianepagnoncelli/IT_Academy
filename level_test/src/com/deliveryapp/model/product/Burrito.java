package com.deliveryapp.model.product;

public class Burrito extends Product {
    public Burrito() {
        super("Burrito", 6.5);
    }

    @Override
    public void showGift() {
        System.out.println("  -> Free gift: Hot Sauce");
    }
}
