package me.sup2is;

public abstract class Electronic {

    protected final Volt volt;

    protected Electronic(Volt volt) {
        this.volt = volt;
    }

    abstract void use();

    public boolean is220V() {
        return this.volt == Volt.V220;
    }
}
