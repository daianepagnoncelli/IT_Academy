package n1exercise2;

import java.util.Date;

public class OnsiteWorker extends Worker {
    private static double petrol = 50.0; // Static attribute for petrol cost

    public OnsiteWorker(String firstName, String lastName, double pricePerHour) {
        super(firstName, lastName, pricePerHour);
    }

    @Override
    public double calculateSalary(double hoursWorked) {
        // Calculate salary for onsite worker (hourly wage * hours worked) + petrol cost
        return super.calculateSalary(hoursWorked) + petrol;
    }

    @Deprecated
    public void oldMethod() {
        // Some old method implementation
    }
}
