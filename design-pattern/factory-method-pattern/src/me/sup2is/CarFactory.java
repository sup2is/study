package me.sup2is;

import me.sup2is.component.Frame;
import me.sup2is.component.Wheel;

import java.util.LinkedList;
import java.util.List;

public abstract class CarFactory {

    private final List<Car> cars = new LinkedList<>();

    public CarFactory() {
        System.out.println(this.getClass());
        Wheel wheel = createWheel();
        Frame frame = createFrame();
        Car car = new Car(frame,wheel);
        cars.add(car);
    }

    abstract protected Frame createFrame();
    abstract protected Wheel createWheel();

    public List<Car> getCars() {
        return cars;
    }
}
