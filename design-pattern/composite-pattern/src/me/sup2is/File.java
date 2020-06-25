package me.sup2is;

public class File implements FileSystem {

    String name;

    @Override
    public void print() {
        System.out.println(this.getClass().getSimpleName() + "(" + name + ")");
    }

    public File(String name) {
        this.name = name;
    }
}
