package n3exercise1;

public class Smartphone implements Telephone {
    @Override
    public void call() {
        System.out.println("Calling from Smartphone...");
    }

    public void makePhotos() {
        System.out.println("Taking photos from Smartphone...");
    }
}
