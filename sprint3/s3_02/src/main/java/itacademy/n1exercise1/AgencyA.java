package itacademy.n1exercise1;

public class AgencyA implements StockObserver {
    @Override
    public void update(boolean stockUp) {
        if (stockUp) {
            System.out.println("AgencyA: The stock market is up!");
        } else {
            System.out.println("AgencyA: The stock market is down!");
        }
    }
}
