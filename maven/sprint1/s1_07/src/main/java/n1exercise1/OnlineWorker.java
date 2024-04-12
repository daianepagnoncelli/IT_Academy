package n1exercise1;

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

}
