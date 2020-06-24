package me.sup2is;

import me.sup2is.component.Frame;
import me.sup2is.component.Wheel;

public class Car {

    private Frame frame;
    private Wheel wheel;

    public Car(Frame frame, Wheel wheel) {
        this.frame = frame;
        this.wheel = wheel;
    }

    public Frame getFrame() {
        return frame;
    }

    public Wheel getWheel() {
        return wheel;
    }
}
