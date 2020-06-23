package me.sup2is;

public class Frame {

    private String name;
    private String color;

    public Frame(String name, String color) {
        this.name = name;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Frame{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
