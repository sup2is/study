package me.sup2is;

public class Main {

    public static void main(String[] args) {

        Burger burger = new CheeseBurger();

        burger.description();
        System.out.println(burger.price() + "원");
        System.out.println("=============================================");

        Burger extraMayo = new ExtraMayonnaise(new CheeseBurger());

        extraMayo.description();
        System.out.println(extraMayo.price() + "원");
        System.out.println("=============================================");

        Burger doubleExtraCheese = new ExtraCheese(new ExtraCheese(extraMayo));

        doubleExtraCheese.description();
        System.out.println(doubleExtraCheese.price() + "원");
        System.out.println("=============================================");

    }

}
