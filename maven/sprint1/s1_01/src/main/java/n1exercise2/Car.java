package n1exercise2;

class Car {
    static final String make = "Tesla";
    static final String model = "X";
    final int power = 1020;

    public Car() {}

    public static void slow() {
        System.out.println("The vehicle is slowing down.");
    }

    public void accelerate() {
        System.out.println("The vehicle is accelerating.");
    }

    public void brake() {
        System.out.println("The vehicle is braking.");
    }
}