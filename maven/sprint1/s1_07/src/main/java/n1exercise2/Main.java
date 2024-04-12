package n1exercise2;

@SuppressWarnings("deprecation")
public class Main {
    public static void main(String[] args) {
        // Create an OnsiteWorker and an OnlineWorker
        OnsiteWorker onsiteWorker = new OnsiteWorker("John", "Doe", 20.0);
        OnlineWorker onlineWorker = new OnlineWorker("Jane", "Smith", 25.0);

        // Demonstrate overriding and calculate salaries
        double hoursWorked = 40.0; // Assume 40 hours worked per month

        // Calculate salary for onsite worker
        double onsiteSalary = onsiteWorker.calculateSalary(hoursWorked);
        System.out.println("Onsite Worker Salary: $" + onsiteSalary);

        // Calculate salary for online worker
        double onlineSalary = onlineWorker.calculateSalary(hoursWorked);
        System.out.println("Online Worker Salary: $" + onlineSalary);

        // Call deprecated method, suppressing warning
        onsiteWorker.oldMethod();
        onlineWorker.oldMethod();
    }
}
