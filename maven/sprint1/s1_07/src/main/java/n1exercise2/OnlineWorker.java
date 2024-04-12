package n1exercise2;

import java.util.Date;

public class OnlineWorker extends Worker {
    private static final double INTERNET_RATE = 30.0; // Constant for Internet rate

    public OnlineWorker(String firstName, String lastName, double pricePerHour) {
        super(firstName, lastName, pricePerHour);
    }

    @Override
    public double calculateSalary(double hoursWorked) {
        // Calculate salary for online worker (hourly wage * hours worked) + Internet rate
        return super.calculateSalary(hoursWorked) + INTERNET_RATE;
    }

    @Deprecated
    public void oldMethod() {
        // Some old method implementation
    }
}
