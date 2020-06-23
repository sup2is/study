package me.sup2is;

public class Main {

    public static void main(String[] args) {

        Frame frame = new Frame("avante V1", "red");
        Wheel wheel = new Wheel("avante V1", 18);

        Avante redAvante = new Avante(frame, wheel);

        Avante newAvante = (Avante) redAvante.clone(); // <- 객체 복사
        Frame newFrame = new Frame("avante V2", "white");
        newAvante.changeFrame(newFrame);

        System.out.println(redAvante);
        System.out.println(newAvante);

    }
}
