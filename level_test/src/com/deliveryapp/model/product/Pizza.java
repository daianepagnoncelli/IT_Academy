package com.deliveryapp.model.product;

public class Pizza extends Product {
    public Pizza() {
        super("Pizza", 7.9);
    }

    @Override
    public void showGift() {
        System.out.println("  -> NO GIFT");
    }
}

