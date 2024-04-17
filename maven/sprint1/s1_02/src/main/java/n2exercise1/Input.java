package n2exercise1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public static byte readByte(String message) {
        byte input = 0;
        boolean isValid = false;
        while (!isValid) {
            try {
                System.out.print(message);
                input = scanner.nextByte();
                isValid = true;
            } catch (InputMismatchException e) {
                System.out.println("Format Error. Please enter a valid byte.");
                scanner.nextLine();
            }
        }
        return input;
    }

    public static int readInt(String message) {
        int input = 0;
        boolean isValid = false;
        while (!isValid) {
            try {
                System.out.print(message);
                input = scanner.nextInt();
                isValid = true;
            } catch (InputMismatchException e) {
                System.out.println("Format Error. Please enter a valid integer.");
                scanner.nextLine();
            }
        }
        return input;
    }

    public static float readFloat(String message) {
        float input = 0;
        boolean isValid = false;
        while (!isValid) {
            try {
                System.out.print(message);
                input = scanner.nextFloat();
                isValid = true;
            } catch (InputMismatchException e) {
                System.out.println("Format Error. Please enter a valid float.");
                scanner.nextLine();
            }
        }
        return input;
    }

    public static double readDouble(String message) {
        double input = 0;
        boolean isValid = false;
        while (!isValid) {
            try {
                System.out.print(message);
                input = scanner.nextDouble();
                isValid = true;
            } catch (InputMismatchException e) {
                System.out.println("Format Error. Please enter a valid double.");
                scanner.nextLine();
            }
        }
        return input;
    }

    public static char readChar(String message) {
        char input = ' ';
        boolean isValid = false;
        while (!isValid) {
            try {
                System.out.print(message);
                input = scanner.next().charAt(0);
                isValid = true;
            } catch (Exception e) {
                System.out.println("Error. Please enter a valid character.");
                scanner.nextLine();
            }
        }
        return input;
    }

    public static String readString(String message) {
        System.out.print(message + ": ");
        scanner.nextLine();
        while (true) {
            try {
                return scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Error. Please enter a valid input.");
                System.out.print(message + ": ");
                scanner.nextLine();
            }
        }
    }

    public static boolean readIfNo(String message) {
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine().trim().toLowerCase();
                if (input.equals("s")) {
                    return true;
                } else if (input.equals("n")) {
                    return false;
                } else {
                    System.out.println("Invalid input. Please enter 's' or 'n'.");
                }
            } catch (Exception e) {
                System.out.println("Error. Please enter a valid input.");
            }
        }
    }


    public static void closeScanner() {
        scanner.close();
    }
}
