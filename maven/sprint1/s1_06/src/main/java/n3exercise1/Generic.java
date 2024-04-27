package n3exercise1;

public class Generic {
    public <T extends Telephone> void makeCall(T phone) {
        phone.call();
    }

    public void takePhotos(Smartphone smartphone) {
        smartphone.makePhotos();
    }
}

