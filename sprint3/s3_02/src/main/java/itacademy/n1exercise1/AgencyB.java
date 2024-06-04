package itacademy.n1exercise1;

public class AgencyB implements StockObserver {
    @Override
    public void update(boolean stockUp) {
        if (stockUp) {
            System.out.println("AgencyB: The stock market is up!");
        } else {
            System.out.println("AgencyB: The stock market is down!");
        }
    }
}

