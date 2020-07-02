package me.sup2is;

public class IncTemperatureCommand implements Command{

    private AirConditioner airConditioner;

    public IncTemperatureCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        airConditioner.increase();
    }
}
