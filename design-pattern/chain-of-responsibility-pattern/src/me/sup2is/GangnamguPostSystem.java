package me.sup2is;

public class GangnamguPostSystem extends ClassificationSystem {

    @Override
    public void classify(Post post) {
        if(post.getDestination().equals("강남구")) {
            System.out.println(post.getId() + "번 포스트를 강남구로 분류!");
        }else {
            system.classify(post);
        }
    }

    @Override
    public void setNext(ClassificationSystem system) {
        this.system = system;
    }
}
