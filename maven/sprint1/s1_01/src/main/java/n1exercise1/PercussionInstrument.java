package n1exercise1;

public class PercussionInstrument extends MusicalInstrument{
    public PercussionInstrument(String name, double price) {
        super(name, price);
    }

    public void play() {
        System.out.println("A percussion instrument is being played");
    }
}
