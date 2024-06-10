package n1exercise1;

import java.util.List;
import java.util.Scanner;

public class AppTools {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Undo undo = Undo.getInstance();

    public static void displayMenu() {
        int option;
        String command;

        do {
            option = inputInt("""
                Select an option:
                1. Add command
                2. Undo (remove the last command)
                3. Delete command
                4. List commands
                0. Exit
                """);

            switch (option) {
                case 1:
                    command = inputString("Enter an action: ");
                    undo.addCommand(command);
                    System.out.println("Command added: " + command);
                    break;
                case 2:
                    undo.removeLastCommand();
                    System.out.println("Last command removed.");
                    break;
                case 3:
                    command = inputString("Enter the action to delete: ");
                    if (undo.removeCommand(command)) {
                        System.out.println("Command deleted: " + command);
                    } else {
                        System.out.println("Command not found: " + command);
                    }
                    break;
                case 4:
                    List<String> commandList = undo.getCommands();
                    if (commandList.isEmpty()) {
                        System.out.println("No commands recorded yet.");
                    } else {
                        System.out.println("Command History:");
                        for (String cmd : commandList) {
                            System.out.println(cmd);
                        }
                    }
                    break;
                case 0:
                    System.out.println("Bye-Bye");
                    break;
                default:
                    System.out.println("Invalid option. Please select again.");
                    break;
            }
        } while (option != 0);
    }

    public static int inputInt(String request) {
        while (true) {
            try {
                System.out.println(request);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Format Error. Please enter a valid integer.");
            }
        }
    }

    public static String inputString(String message) {
        String userInput = "";
        while (userInput.isEmpty()) {
            System.out.println(message);
            userInput = scanner.nextLine().trim();
            if (userInput.isEmpty()) {
                System.err.println("Input cannot be empty. Please enter a valid string.");
            }
        }
        return userInput;
    }
}


