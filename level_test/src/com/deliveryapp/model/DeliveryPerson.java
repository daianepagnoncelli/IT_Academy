package com.deliveryapp.model;

public class DeliveryPerson {
    public enum Method {
        BICYCLE,
        MOTORCYCLE,
        ON_FOOT
    }

    private final String name;
    private boolean available;
    private final Method method;

    public DeliveryPerson(String name, Method method) {
        this.name = name;
        this.method = method;
        this.available = true;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Method getMethod() {
        return method;
    }

    public double calculateAdditionalCost() {
        return switch (method) {
            case BICYCLE -> 0.01;
            case MOTORCYCLE -> 0.02;
            default -> 0.0;
        };
    }
}

