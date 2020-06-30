package me.sup2is;

public class Main {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        ClothesFactory.getClothes(ClothesType.SHIRT,"AA0001", 100, "red", "강남점");
        ClothesFactory.getClothes(ClothesType.SHIRT,"AA0001", 100, "red", "신사점");
        ClothesFactory.getClothes(ClothesType.SHIRT,"AA0001", 100, "red", "역삼점");
        ClothesFactory.getClothes(ClothesType.SHIRT,"AA0001", 100, "red", "홍대점");
        ClothesFactory.getClothes(ClothesType.SHIRT,"AA0002", 95, "black", "강남점");
        ClothesFactory.getClothes(ClothesType.PANT, "AA0003", 100, "blue", "교대점");
        ClothesFactory.getClothes(ClothesType.PANT, "AA0003", 100, "blue", "강남점");

        long end = System.currentTimeMillis();

        System.out.println("프로그램 수행 시간: " + (end - start) / 1000 + "초");

    }

}
