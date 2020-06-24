package me.sup2is;

public abstract class Pizza {

    private PizzaImp pizzaImp;

    public Pizza(PizzaImp pizzaImp) {
        this.pizzaImp = pizzaImp;
    }

    public void taste() {
        pizzaImp.taste();
    }

}
