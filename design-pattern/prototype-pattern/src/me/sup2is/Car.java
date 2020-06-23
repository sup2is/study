package me.sup2is;

public abstract class Car implements Cloneable {

    public Frame frame;
    public Wheel wheel;

    public Car(Frame frame, Wheel wheel) {
        this.frame = frame;
        this.wheel = wheel;
    }

    @Override
    public String toString() {
        return "Car{" +
                "frame=" + frame +
                ", wheel=" + wheel +
                '}';
    }

    @Override
    protected Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
