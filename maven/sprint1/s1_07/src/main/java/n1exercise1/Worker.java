package n1exercise1;

public class Worker {

    private String firstName;
    private String lastName;
    private double pricePerHour;

    public Worker(String firstName, String lastName, double pricePerHour) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pricePerHour = pricePerHour;
    }

    public double calculateSalary(double hoursWorked) {
        return hoursWorked * pricePerHour;
    }
}
