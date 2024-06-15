package com.deliveryapp.model;

import com.deliveryapp.exception.NoDeliveryPersonAvailableException;

import java.util.Optional;
import java.util.stream.Stream;

public enum DeliveryPerson {
    NICO("Nico", true),
    JAYDEN("Jayden", true),
    TIAGO("Tiago", true);

    private final String name;
    private boolean available;

    DeliveryPerson(String name, boolean available) {
        this.name = name;
        this.available = available;
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

    public static DeliveryPerson selectRandomAvailable() throws NoDeliveryPersonAvailableException {
        Optional<DeliveryPerson> randomAvailablePerson = Stream.of(DeliveryPerson.values())
                .filter(DeliveryPerson::isAvailable)
                .findAny();

        return randomAvailablePerson.orElseThrow(() -> new NoDeliveryPersonAvailableException("No delivery person available."));
    }
}

