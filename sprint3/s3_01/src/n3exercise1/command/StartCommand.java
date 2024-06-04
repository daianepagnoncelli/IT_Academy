package n3exercise1.command;

import n3exercise1.Command;
import n3exercise1.Vehicle;

public class StartCommand implements Command {
    private final Vehicle vehicle;

    public StartCommand(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void execute() {
        vehicle.start();
    }
}
