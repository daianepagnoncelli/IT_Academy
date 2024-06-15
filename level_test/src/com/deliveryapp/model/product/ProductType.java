package com.deliveryapp.model.product;

import java.util.function.Supplier;

public enum ProductType {
    BURGER(Burger::new, "Burger"),
    BURRITO(Burrito::new, "Burrito"),
    KEBAB(Kebab::new, "Kebab"),
    PIZZA(Pizza::new, "Pizza");

    private final Supplier<Product> constructor;
    private final String productName;

    ProductType(Supplier<Product> constructor, String productName) {
        this.constructor = constructor;
        this.productName = productName;
    }

    public Product createProduct() {
        return constructor.get();
    }

    public String getProductName() {
        return productName;
    }
}
