package me.sup2is;

public class SongpaguPostSystem extends ClassificationSystem {


    @Override
    public void classify(Post post) {
        if(post.getDestination().equals("서초구")) {
            System.out.println(post.getId() + "번 포스트를 서초구로 분류!");
        }else {
            system.classify(post);
        }
    }

    @Override
    public void setNext(ClassificationSystem system) {
        this.system = system;
    }
}
