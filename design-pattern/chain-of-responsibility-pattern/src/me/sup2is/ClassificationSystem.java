package me.sup2is;

public abstract class ClassificationSystem {

    protected ClassificationSystem system;

    public abstract void classify(Post post);
    public abstract void setNext(ClassificationSystem system);

}
