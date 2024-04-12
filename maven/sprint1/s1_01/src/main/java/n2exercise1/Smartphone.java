package n2exercise1;

public class Smartphone {
    public Smartphone(String make, String model) {
        super(make, model);
    }

    @Override
    public void photograph() {
        System.out.println("A picture is being taken");
    }

    @Override
    public void alarm() {
        System.out.println("The alarm is sounding");
    }
}
