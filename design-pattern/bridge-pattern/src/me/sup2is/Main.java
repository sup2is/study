package me.sup2is;

public class Main {

    public static void main(String[] args) {

        Dough dough = new Dough(new PepperoniPizza());
        dough.taste();

        //갑자기 고객이 주문을 변경함
        dough = new Dough(new ChicagoPizza());
        dough.taste();

        //갑자기 고객이 주문을 또 변경함
        dough = new Dough(new MargheritaPizza());
        dough.taste();
    }
}
