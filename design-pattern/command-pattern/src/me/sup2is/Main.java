package me.sup2is;

public class Main {

    public static void main(String[] args) {

        AirConditioner airConditioner = new AirConditioner();

        Command decTemperatureCommand = new DecTemperatureCommand(airConditioner);
        Command incTemperatureCommand = new IncTemperatureCommand(airConditioner);
        Command powerCommand = new PowerCommand(airConditioner);

        RemoteController remoteController = new RemoteController(powerCommand);
        remoteController.pressButton();

        remoteController.setCommand(incTemperatureCommand);

        remoteController.pressButton();
        remoteController.pressButton();
        remoteController.pressButton();
        remoteController.pressButton();
        remoteController.pressButton();

        remoteController.setCommand(decTemperatureCommand);

        remoteController.pressButton();
        remoteController.pressButton();
        remoteController.pressButton();
        remoteController.pressButton();

        remoteController.setCommand(powerCommand);
        remoteController.pressButton();

    }

}
