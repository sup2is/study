package me.sup2is;

import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystem {

    String name;

    private List<FileSystem> files = new ArrayList<>();

    @Override
    public void print() {
        System.out.println(this.getClass().getSimpleName() + "(" + name + ")");
        files.forEach(fileSystem -> fileSystem.print());
    }

    public void addFile(FileSystem file) {
        files.add(file);
    }

    public Folder(String name) {
        this.name = name;
    }
}
