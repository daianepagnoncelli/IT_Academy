package itacademy.n1exercise1;

import java.util.ArrayList;
import java.util.List;

public class Stock implements Observable {
    private double stockPrice;
    private String symbol;
    private List<Observer> observers;

    public Stock(String symbol) {
        this.symbol = symbol;
        this.observers = new ArrayList<>();
    }

    @Override
    public void subscribe(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        this.observers.remove(observer);
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : this.observers) {
            observer.update(this.symbol, this.stockPrice);
        }
    }

    public void showSubscribers() {
        for (Observer observer : this.observers) {
            if (observer instanceof StockExchange) {
                System.out.println(((StockExchange) observer).getName());
            }
        }
    }
}

