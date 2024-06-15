package itacademy.n2exercise1.shoeshop;

public class Shoe {
    private final String model;
    private String brand;
    private double price;

    public Shoe(String model, String brand, double price) {
        this.model = model;
        this.brand = brand;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Model: " + model + ", Brand: " + brand + ", Price: " + price + " €";
    }
}
