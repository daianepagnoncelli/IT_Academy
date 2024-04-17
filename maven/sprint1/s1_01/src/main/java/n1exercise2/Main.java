package n1exercise2;

public class Main {
    public static void main(String[] args) {

        System.out.println("Make: " + Car.make);
        System.out.println("Model: " + Car.model);
        Car.slow();
        Car myCar = new Car();
        System.out.println("Motor power: " + myCar.power + "cv");
        myCar.accelerate();
        System.out.println("Traffic light closed");
        myCar.brake();
    }
}



