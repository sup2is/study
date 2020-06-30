package me.sup2is;

public abstract class GatewayUnit {

    int maxHp;
    int maxArmor;
    int power;
    Status status;

    public GatewayUnit(int maxHp, int maxArmor, int power) {
        this.maxHp = maxHp;
        this.maxArmor = maxArmor;
        this.power = power;
    }

    public abstract void attack();
    public void status() {
        System.out.println(getClass().getSimpleName() + " 현재 위치(x, y): " + status.currentX + " : " + status.currentY + ", 현재 상태(hp, armor): " + status.currentHp + " : " + status.currentArmor);
    }
}

class Status {

    int currentX;
    int currentY;
    int currentHp;
    int currentArmor;

    public Status(int currentX, int currentY, int currentHp, int currentArmor) {
        this.currentX = currentX;
        this.currentY = currentY;
        this.currentHp = currentHp;
        this.currentArmor = currentArmor;
    }
}
