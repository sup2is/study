package me.sup2is;

public class Zealot extends GatewayUnit {

    public Zealot(int maxHp, int maxArmor, int power) {
        super(maxHp, maxArmor, power);
    }

    @Override
    public void attack() {
        System.out.println(getClass().getSimpleName() + "! 근거리 공격");
    }

}
