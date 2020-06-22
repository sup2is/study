package me.sup2is;

import me.sup2is.component.AvanteFrame;
import me.sup2is.component.AvanteWheel;
import me.sup2is.component.Frame;
import me.sup2is.component.Wheel;

public class AvanteFactory implements CarFactory {

    @Override
    public Frame createFrame() {
        return new AvanteFrame();
    }

    @Override
    public Wheel createWheel() {
        return new AvanteWheel();
    }
}
