package me.sup2is;

public abstract class BurgerDecorator implements Burger {

    protected Burger burger;

    public BurgerDecorator(Burger burger) {
        this.burger = burger;
    }

}
