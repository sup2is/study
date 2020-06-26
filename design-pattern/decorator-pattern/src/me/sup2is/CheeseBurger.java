package me.sup2is;

public class CheeseBurger implements Burger {

    @Override
    public int price() {
        return 3000;
    }

    @Override
    public void description() {
        System.out.println("Cheese 버거");
    }
}
