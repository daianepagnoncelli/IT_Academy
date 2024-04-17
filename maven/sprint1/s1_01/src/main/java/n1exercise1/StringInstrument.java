package n1exercise1;

class StringInstrument extends Instrument{
    static {
        System.out.println("StringInstrument class is loaded.");
    }

    public StringInstrument(String name, double price) {
        super(name, price);
    }

    @Override
    void touch() {
        System.out.println("A string instrument is being played");
    }
}
