package n1exercise1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select type of instrument:");
        System.out.println("1 - Wind Instrument");
        System.out.println("2 - String Instrument");
        System.out.println("3 - Percussion Instrument");

        int choice = scanner.nextInt();

        scanner.nextLine();

        MusicalInstrument instrument = MusicalInstrumentFactory.createInstrument(choice, scanner);

        if (instrument != null) {
            System.out.println("\nInstrument details:");
            System.out.println("Name: " + instrument.getName());
            System.out.println("Price: $" + instrument.getPrice());
            System.out.println("\nPlaying the instrument:");
            instrument.play();
        }

        scanner.close();
    }
}
    class MusicalInstrumentFactory {
        public static MusicalInstrument createInstrument(int choice, Scanner scanner) {
            String instrumentName;
            double instrumentPrice;

            switch (choice) {
                case 1:
                    System.out.println("Enter the name of the wind instrument:");
                    instrumentName = scanner.nextLine();
                    System.out.println("Enter the price of the wind instrument:");
                    instrumentPrice = Double.parseDouble(scanner.nextLine());
                    return new WindInstrument(instrumentName, instrumentPrice);
                case 2:
                    System.out.println("Enter the name of the string instrument:");
                    instrumentName = scanner.nextLine();
                    System.out.println("Enter the price of the string instrument:");
                    instrumentPrice = Double.parseDouble(scanner.nextLine());
                    return new StringInstrument(instrumentName, instrumentPrice);
                case 3:
                    System.out.println("Enter the name of the percussion instrument:");
                    instrumentName = scanner.nextLine();
                    System.out.println("Enter the price of the percussion instrument:");
                    instrumentPrice = Double.parseDouble(scanner.nextLine());
                    return new PercussionInstrument(instrumentName, instrumentPrice);
                default:
                    System.out.println("Invalid choice!");
                    return null;
            }
        }
    }
