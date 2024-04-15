package n1exercise1;

public class StringInstrument extends MusicalInstrument{
    public StringInstrument(String name, double price) {
        super(name, price);
    }

    public void play() {
        System.out.println("A string instrument is being played");
    }
}
