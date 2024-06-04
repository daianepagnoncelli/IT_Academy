package n3exercise1.transport;

import n3exercise1.Vehicle;

public class Boat implements Vehicle {
    @Override
    public void start() {
        System.out.println("Boat is starting.");
    }

    @Override
    public void accelerate() {
        System.out.println("Boat is accelerating.");
    }

    @Override
    public void brake() {
        System.out.println("Boat is braking.");
    }
}
