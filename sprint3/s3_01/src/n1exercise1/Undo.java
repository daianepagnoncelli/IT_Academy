package n1exercise1;

import java.util.ArrayList;
import java.util.List;

public final class Undo {

    private static Undo instance;
    private final List<String> commands;

    private Undo() {
        try {
            Thread.sleep(1000);   // Slow initialization
        } catch (InterruptedException e) {
            System.err.println("Error during initialization: " + e.getMessage());
        }
        this.commands = new ArrayList<>();
    }

    public static synchronized Undo getInstance() {
        if (instance == null) {
            instance = new Undo();
        }
        return instance;
    }

    public void addCommand(String command) {
        this.commands.add(command);
    }

    public boolean removeCommand(String command) {
        return this.commands.remove(command);
    }

    public void removeLastCommand() {
        if (!commands.isEmpty()) {
            commands.remove(commands.size() - 1);
        }
    }

    public List<String> getCommands() {
        return this.commands;
    }
}