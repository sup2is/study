package me.sup2is;

import me.sup2is.component.Frame;
import me.sup2is.component.Wheel;

public interface CarFactory {
    Frame createFrame();
    Wheel createWheel();
}
