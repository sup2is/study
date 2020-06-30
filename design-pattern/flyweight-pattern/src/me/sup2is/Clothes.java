package me.sup2is;

public abstract class Clothes{

    private String code;
    private int size;
    private String color;

    public Clothes(String code, int size, String color) {
        this.code = code;
        this.size = size;
        this.color = color;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
