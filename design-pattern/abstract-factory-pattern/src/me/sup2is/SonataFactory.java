package me.sup2is;

import me.sup2is.component.Frame;
import me.sup2is.component.SonataFrame;
import me.sup2is.component.SonataWheel;
import me.sup2is.component.Wheel;

public class SonataFactory implements CarFactory {
    @Override
    public Frame createFrame() {
        return new SonataFrame();
    }

    @Override
    public Wheel createWheel() {
        return new SonataWheel();
    }
}
