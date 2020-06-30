package me.sup2is;

public class Dragon extends GatewayUnit {

    public Dragon(int maxHp, int maxArmor, int power) {
        super(maxHp, maxArmor, power);
    }

    @Override
    public void attack() {
        System.out.println(getClass().getSimpleName() + "! 원거리 공격");
    }
}
