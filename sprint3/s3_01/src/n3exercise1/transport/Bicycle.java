package n3exercise1.transport;

import n3exercise1.Vehicle;

public class Bicycle implements Vehicle {
    @Override
    public void start() {
        System.out.println("Bicycle is starting.");
    }

    @Override
    public void accelerate() {
        System.out.println("Bicycle is accelerating.");
    }

    @Override
    public void brake() {
        System.out.println("Bicycle is braking.");
    }
}
