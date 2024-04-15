package n2exercise1;

public class Phone {
    private String make;
    private String model;

    public Phone(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public void call(String phoneNumber) {
        System.out.println("Calling " + phoneNumber + " on " + make + " " + model);
    }
}

