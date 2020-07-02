package me.sup2is;

public class DecTemperatureCommand implements Command{

    private AirConditioner airConditioner;

    public DecTemperatureCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        airConditioner.decrease();
    }
}
