package me.sup2is;

import java.util.HashMap;
import java.util.Map;

public class ClothesFactory {

    private static Map<String, Clothes> map = new HashMap<>();

    public static Product getClothes(ClothesType type, String code, int size, String color, String location){

        Clothes clothes = map.computeIfAbsent(code, u -> {
            Clothes c = createClothes(type, code, size, color);
            map.put(code, c);
            return c;
        });

        return new Product(clothes, location);
    }

    private static Clothes createClothes(ClothesType type, String code, int size, String color) {
        System.out.println(code + " 옷을 생산합니다.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Clothes c = null;

        switch (type) {
            case SHIRT:
                c = new Shirt(code, size, color);
                break;
            case PANT:
                c = new Pants(code, size, color);
                break;
        }

        return c;
    }

}
