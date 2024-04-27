package n1exercise2;

public class Worker {

    private final String firstName;
    private final String lastName;
    private final double pricePerHour;

    public Worker(String firstName, String lastName, double pricePerHour) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pricePerHour = pricePerHour;
    }

    public double calculateSalary(double hoursWorked) {
        return hoursWorked * pricePerHour;
    }
}

