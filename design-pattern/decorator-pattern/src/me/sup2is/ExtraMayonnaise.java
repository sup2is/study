package me.sup2is;

public class ExtraMayonnaise extends BurgerDecorator {

    public ExtraMayonnaise(Burger burger) {
        super(burger);
    }

    @Override
    public void description() {
        burger.description();
        System.out.println("+ 마요네즈 추가");
    }

    @Override
    public int price() {
        return burger.price() + 200;
    }

}
