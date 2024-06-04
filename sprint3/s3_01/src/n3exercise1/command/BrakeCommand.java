package n3exercise1.command;

import n3exercise1.Command;
import n3exercise1.Vehicle;

public class BrakeCommand implements Command {
    private final Vehicle vehicle;

    public BrakeCommand(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void execute() {
        vehicle.brake();
    }
}
