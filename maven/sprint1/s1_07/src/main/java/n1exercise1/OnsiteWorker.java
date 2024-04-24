package n1exercise1;

public class OnsiteWorker extends Worker {
    private static final double petrol = 50.0;

    public OnsiteWorker(String firstName, String lastName, double pricePerHour) {
        super(firstName, lastName, pricePerHour);
    }

    @Override
    public double calculateSalary(double hoursWorked) {
        return super.calculateSalary(hoursWorked) + petrol;
    }

}
