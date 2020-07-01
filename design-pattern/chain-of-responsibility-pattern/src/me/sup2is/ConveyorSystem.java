package me.sup2is;

public class ConveyorSystem extends ClassificationSystem {

    @Override
    public void classify(Post post) {
        system.classify(post);
    }

    @Override
    public void setNext(ClassificationSystem system) {
        this.system = system;
    }
}
