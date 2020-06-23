package me.sup2is;

public class Avante extends Car{

    public Avante(Frame frame, Wheel wheel) {
        super(frame, wheel);
    }

    public void changeFrame(Frame frame) {
        this.frame = frame;
    }

    @Override
    public String toString() {
        return "Avante{" +
                "frame=" + frame +
                ", wheel=" + wheel +
                '}';
    }
}
