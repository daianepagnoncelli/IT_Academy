package itacademy.n1exercise1;

public class Main {
    public static void main(String[] args) {
        StockAgent stockAgent = new StockAgent();

        StockObserver agencyA = new AgencyA();
        StockObserver agencyB = new AgencyB();

        stockAgent.addObserver(agencyA);
        stockAgent.addObserver(agencyB);

        System.out.println("Stock is going up:");
        stockAgent.setStockUp(true);

        System.out.println("\nStock is going down:");
        stockAgent.setStockUp(false);
    }
}
