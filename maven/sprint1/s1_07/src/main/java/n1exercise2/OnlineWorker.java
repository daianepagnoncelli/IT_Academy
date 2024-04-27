package n1exercise2;

public class OnlineWorker extends Worker {
    private static final double INTERNET_RATE = 30.0;

    public OnlineWorker(String firstName, String lastName, double pricePerHour) {
        super(firstName, lastName, pricePerHour);
    }

    @Override
    public double calculateSalary(double hoursWorked) {
        return super.calculateSalary(hoursWorked) + INTERNET_RATE;
    }

    @Deprecated
    public void calculateBonus(double amount) {
        System.out.println("Calculating bonus for Online Worker: $" + amount);
    }
}
