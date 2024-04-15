package n1exercise5;

public class Main {
    public static void main(String[] args) {
        PiProvider piProvider = new PiProviderImpl();

        double piValue = piProvider.getPiValue();
        System.out.println("Pi value: " + piValue);
    }
}
