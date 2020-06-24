package me.sup2is;

public class Main {

    public static void main(String[] args) {
        CarFactory avanteFactory = new AvanteFactory();
        Car avante = new Car(avanteFactory.createFrame(), avanteFactory.createWheel());
        avante.getFrame().shape();
        avante.getWheel().size();

        System.out.println("================");

        CarFactory sonataFactory = new SonataFactory();
        Car sonata = new Car(sonataFactory.createFrame(), sonataFactory.createWheel());
        sonata.getFrame().shape();
        sonata.getWheel().size();

        System.out.println("Sonata 물량 : " + sonataFactory.getCars().size());
        System.out.println("Avante 물량 : " + avanteFactory.getCars().size());

    }
}
