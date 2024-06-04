package n1exercise1;

import java.util.ArrayList;
import java.util.List;

public class Undo {
    private static Undo instance;
    private final List<String> commands;

    private Undo() {
        commands = new ArrayList<>();
    }

    public static Undo getInstance() {
        if (instance == null) {
            instance = new Undo();
        }
        return instance;
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    public void removeCommand() {
        if (!commands.isEmpty()) {
            commands.remove(commands.size() - 1);
        }
    }

    public List<String> listCommands() {
        return new ArrayList<>(commands);
    }
}

