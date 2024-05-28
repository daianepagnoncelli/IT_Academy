package itacademy.n1exercise1;

public class AgencyB implements StockObserver {
    private final String name = "Agency B";

    @Override
    public void update(boolean stockUp) {
        if (stockUp) {
            System.out.println(name + ": The stock market is up!");
        } else {
            System.out.println(name + ": The stock market is down!");
        }
    }
}
