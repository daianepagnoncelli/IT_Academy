package n1exercise1;

import java.util.ArrayList;
import java.util.List;

public class Undo {
    // Private static instance of the same class
    private static Undo instance;

    // List to store the commands
    private final List<String> commands;

    // Private constructor to restrict instantiation from other classes
    private Undo() {
        commands = new ArrayList<>();
    }

    // Public static method to provide access to the instance
    public static Undo getInstance() {
        if (instance == null) {
            instance = new Undo();
        }
        return instance;
    }

    // Method to add a command
    public void addCommand(String command) {
        commands.add(command);
    }

    // Method to remove the last command
    public void removeCommand() {
        if (!commands.isEmpty()) {
            commands.remove(commands.size() - 1);
        }
    }

    // Method to list all commands
    public List<String> listCommands() {
        return new ArrayList<>(commands);
    }
}

