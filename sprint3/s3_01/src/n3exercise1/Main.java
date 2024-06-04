package n3exercise1;

public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle bicycle = new Bicycle();
        Vehicle plane = new Plane();
        Vehicle boat = new Boat();

        Command startCar = new StartCommand(car);
        Command accelerateCar = new AccelerateCommand(car);
        Command brakeCar = new BrakeCommand(car);

        Command startBicycle = new StartCommand(bicycle);
        Command accelerateBicycle = new AccelerateCommand(bicycle);
        Command brakeBicycle = new BrakeCommand(bicycle);

        Command startPlane = new StartCommand(plane);
        Command acceleratePlane = new AccelerateCommand(plane);
        Command brakePlane = new BrakeCommand(plane);

        Command startBoat = new StartCommand(boat);
        Command accelerateBoat = new AccelerateCommand(boat);
        Command brakeBoat = new BrakeCommand(boat);

        ListCommand listCommand = new ListCommand();

        listCommand.addCommand(startCar);
        listCommand.addCommand(accelerateCar);
        listCommand.addCommand(brakeCar);

        listCommand.addCommand(startBicycle);
        listCommand.addCommand(accelerateBicycle);
        listCommand.addCommand(brakeBicycle);

        listCommand.addCommand(startPlane);
        listCommand.addCommand(acceleratePlane);
        listCommand.addCommand(brakePlane);

        listCommand.addCommand(startBoat);
        listCommand.addCommand(accelerateBoat);
        listCommand.addCommand(brakeBoat);

        listCommand.executeCommands();
    }
}
