package n1exercise2;

public class OnsiteWorker extends Worker {
    private static final double PETROL = 50.0;

    public OnsiteWorker(String firstName, String lastName, double pricePerHour) {
        super(firstName, lastName, pricePerHour);
    }

    @Override
    public double calculateSalary(double hoursWorked) {
        return super.calculateSalary(hoursWorked) + PETROL;
    }

    @Deprecated
    public void calculateBonus(double amount) {
        System.out.println("Calculating bonus for Onsite Worker: $" + amount);
    }
}

