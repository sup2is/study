package me.sup2is;

public class Main {

    public static void main(String[] args) {

        HairDryer hairDryer = new HairDryer(Volt.V220); //<- 변경 불가능한 third party lib

        VoltageAdapter v = new VoltageAdapter(hairDryer);
        v.apply();

    }
}
