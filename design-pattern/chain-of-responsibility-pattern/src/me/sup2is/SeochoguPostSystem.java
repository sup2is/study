package me.sup2is;

public class SeochoguPostSystem extends ClassificationSystem {

    @Override
    public void classify(Post post) {
        if(post.getDestination().equals("송파구")) {
            System.out.println(post.getId() + "번 포스트를 송파구로 분류!");
        }else {
            system.classify(post);
        }
    }

    @Override
    public void setNext(ClassificationSystem system) {
        this.system = system;
    }
}
