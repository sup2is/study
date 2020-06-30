package me.sup2is;

import java.util.HashMap;
import java.util.Map;

public class Gateway {

    private static Map<UnitType, GatewayUnit> map = new HashMap<>();

    public static GatewayUnit getUnit(UnitType unitType) {

        GatewayUnit gatewayUnit = map.computeIfAbsent(unitType, u -> {

            GatewayUnit g = null;

            switch (unitType) {
                case ZEALOT:
                    g = new Zealot(50, 50, 10);
                    break;
                case DRAGON:
                    g = new Dragon(75, 50, 10);
                    break;
                case DARKTEMPLAR:
                    g = new DarkTemplar(50, 50, 20);
                    break;
                case HIGHTEMPLAR:
                    g = new HighTemplar(25, 75, 0);
                    break;
            }

            return g;
        });

        return gatewayUnit;
    }





}
