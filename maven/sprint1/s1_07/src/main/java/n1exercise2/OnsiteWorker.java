package n1exercise2;

public class OnsiteWorker extends Worker {
    private final static double petrol = 50.0;

    public OnsiteWorker(String firstName, String lastName, double pricePerHour) {
        super(firstName, lastName, pricePerHour);
    }

    @Override
    public double calculateSalary(double hoursWorked) {
        return super.calculateSalary(hoursWorked) + petrol;
    }

    @Deprecated
    public void oldMethod() {

    }
}
