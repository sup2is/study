package me.sup2is;

public class Wheel {

    private String name;
    private int size;

    public Wheel(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Wheel{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}
