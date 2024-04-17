package n1exercise1;

abstract class Instrument {
    protected String name;
    protected double price;

    public Instrument(String name, double price) {
        this.name = name;
        this.price = price;
    }

    abstract void touch();
}