package itacademy.n1exercise1;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

        Stock AAPLStock = new Stock("AAPL");
        Stock AMZNStock = new Stock("AMZN");

        StockExchange nasdaq = new StockExchange("Nasdaq");
        StockExchange euronext = new StockExchange("Euronext");

        System.out.println("");
        AAPLStock.setStockPrice(212.44);
        AMZNStock.setStockPrice(181.30);

        AAPLStock.subscribe(nasdaq);
        AMZNStock.subscribe(nasdaq);

        AAPLStock.subscribe(euronext);
        AMZNStock.subscribe(euronext);

        AMZNStock.unsubscribe(nasdaq);
        AAPLStock.setStockPrice(211.30);
        AMZNStock.setStockPrice(183.20);
        AAPLStock.setStockPrice(213.85);

        System.out.println("\nApple Inc (AAPL) subscribers are:");
        AAPLStock.showSubscribers();

        System.out.println("\nAmazon.com Inc (AMZN) subscribers are:");
        AMZNStock.showSubscribers();
    }
}

