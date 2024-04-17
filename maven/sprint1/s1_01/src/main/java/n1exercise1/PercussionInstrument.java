package n1exercise1;

class PercussionInstrument extends Instrument{
    static {
        System.out.println("PercussionInstrument class is loaded.");
    }

    public PercussionInstrument(String name, double price) {
        super(name, price);
    }

    @Override
    void touch() {
        System.out.println("A percussion instrument is being played");
    }
}
