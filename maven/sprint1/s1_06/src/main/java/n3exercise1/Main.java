package n3exercise1;

public class Main {
    public static void main(String[] args) {
        Smartphone smartphone = new Smartphone();

        Generic generic = new Generic();
        generic.makeCall(smartphone);
        generic.takePhotos(smartphone);
    }
}

