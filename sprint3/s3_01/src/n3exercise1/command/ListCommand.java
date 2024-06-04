package n3exercise1.command;

import n3exercise1.Command;

import java.util.ArrayList;
import java.util.List;

public class ListCommand {
    private final List<Command> commands = new ArrayList<>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void executeCommands() {
        for (Command command : commands) {
            command.execute();
        }
        commands.clear();
    }
}
