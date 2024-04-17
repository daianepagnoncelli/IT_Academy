package n1exercise1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the wind instrument:");
        String windName = scanner.nextLine();

        System.out.println("Enter the price of the wind instrument - Use comma to enter the price:");
        double windPrice = scanner.nextDouble();
        scanner.nextLine();

        WindInstrument windInstrument = new WindInstrument(windName, windPrice);
        windInstrument.touch();

        System.out.println("Enter the name of the string instrument:");
        String stringName = scanner.nextLine();

        System.out.println("Enter the price of the string instrument - Use comma to enter the price:");
        double stringPrice = scanner.nextDouble();
        scanner.nextLine();

        StringInstrument stringInstrument = new StringInstrument(stringName, stringPrice);
        stringInstrument.touch();

        System.out.println("Enter the name of the percussion instrument:");
        String percussionName = scanner.nextLine();

        System.out.println("Enter the price of the percussion instrument - Use comma to enter the price:");
        double percussionPrice = scanner.nextDouble();

        PercussionInstrument percussionInstrument = new PercussionInstrument(percussionName, percussionPrice);
        percussionInstrument.touch();

        scanner.close();
    }

}
