package n3exercise1.command;

import n3exercise1.Command;
import n3exercise1.Vehicle;

public class AccelerateCommand implements Command {
    private final Vehicle vehicle;

    public AccelerateCommand(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void execute() {
        vehicle.accelerate();
    }
}
