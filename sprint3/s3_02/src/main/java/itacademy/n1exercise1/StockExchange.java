package itacademy.n1exercise1;

public class StockExchange implements Observer {
    private String name;

    public StockExchange(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void update(String stockSymbol, double stockPrice) {
        System.out.println(name + ", " + stockSymbol + " price is now " + stockPrice);
    }
}

