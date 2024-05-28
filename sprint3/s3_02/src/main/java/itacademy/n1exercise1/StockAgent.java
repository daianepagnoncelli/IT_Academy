package itacademy.n1exercise1;

import java.util.ArrayList;
import java.util.List;

public class StockAgent {
    private final List<StockObserver> observers = new ArrayList<>();
    private boolean stockUp;

    public void addObserver(StockObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(StockObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (StockObserver observer : observers) {
            observer.update(stockUp);
        }
    }

    public void setStockUp(boolean stockUp) {
        this.stockUp = stockUp;
        notifyObservers();
    }
}
