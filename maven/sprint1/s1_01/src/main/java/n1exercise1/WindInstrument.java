package n1exercise1;

public class WindInstrument extends Instrument{
    static {
        System.out.println("WindInstrument class is loaded.");
    }

    public WindInstrument(String name, double price) {
        super(name, price);
    }

    @Override
    void touch() {
        System.out.println("A wind instrument is being played");
    }
}
