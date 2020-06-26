package me.sup2is;

public class ExtraCheese extends BurgerDecorator {

    public ExtraCheese(Burger burger) {
        super(burger);
    }

    @Override
    public void description() {
        burger.description();
        System.out.println("+ 치즈 추가");
    }

    @Override
    public int price() {
        return burger.price() + 300;
    }

}
