package n1exercise1;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Undo undoManager = Undo.getInstance();

        while (true) {
            System.out.println("Enter a command (add <command>, remove, list, exit):");
            String input = scanner.nextLine();
            String[] parts = input.split(" ", 2);
            String command = parts[0];

            switch (command.toLowerCase()) {
                case "add":
                    if (parts.length > 1) {
                        undoManager.addCommand(parts[1]);
                        System.out.println("Command added: " + parts[1]);
                    } else {
                        System.out.println("Please provide a command to add.");
                    }
                    break;
                case "remove":
                    undoManager.removeCommand();
                    System.out.println("Last command removed.");
                    break;
                case "list":
                    List<String> commands = undoManager.listCommands();
                    System.out.println("Command history:");
                    for (String cmd : commands) {
                        System.out.println(cmd);
                    }
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Unknown command. Please try again.");
                    break;
            }
        }
    }
}

