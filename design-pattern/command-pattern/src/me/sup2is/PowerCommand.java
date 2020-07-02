package me.sup2is;

public class PowerCommand implements Command {

    private AirConditioner airConditioner;

    public PowerCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        airConditioner.togglePower();
    }
}
