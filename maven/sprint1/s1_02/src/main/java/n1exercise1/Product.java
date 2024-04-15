package n1exercise1;

public class Product {
    private final String name;
    private final double price;

    public Product (String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
