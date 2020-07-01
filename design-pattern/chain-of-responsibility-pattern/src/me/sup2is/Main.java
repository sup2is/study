package me.sup2is;

public class Main {

    public static void main(String[] args) {

        ConveyorSystem conveyorSystem = new ConveyorSystem();
        GangnamguPostSystem gangnamguPostSystem = new GangnamguPostSystem();
        SongpaguPostSystem songpaguPostSystem = new SongpaguPostSystem();
        SeochoguPostSystem seochoguPostSystem = new SeochoguPostSystem();

        conveyorSystem.setNext(gangnamguPostSystem);
        gangnamguPostSystem.setNext(songpaguPostSystem);
        songpaguPostSystem.setNext(seochoguPostSystem);


        Post post1 = new Post(1, "강남구", "bla bla ...");
        Post post2 = new Post(2, "서초구", "bla bla ...");
        Post post3 = new Post(3, "송파구", "bla bla ...");
        Post post4 = new Post(4, "노원구", "bla bla ...");

        conveyorSystem.classify(post1);
        conveyorSystem.classify(post2);
        conveyorSystem.classify(post3);
        conveyorSystem.classify(post4);

    }

}
