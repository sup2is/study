package me.sup2is;

public class AirConditioner {

    private boolean operation;
    private int windStrength;


    public AirConditioner() {
        windStrength = 27;
        operation = false;
    }

    public void togglePower() {
        operation = !operation;
        System.out.println("현재 에어컨 동작 상태 : " + (operation ? "실행중" : "종료"));
    }

    public void increase() {
        if(!operation) {
            System.out.println("에어컨이 동작하지 않습니다!");
            return;
        }

        if(windStrength < 30) {
            windStrength ++;
        }

        System.out.println("현재 온도 : " + windStrength);
    }

    public void decrease() {
        if(!operation) {
            System.out.println("에어컨이 동작하지 않습니다!");
            return;
        }

        if(windStrength > 18) {
            windStrength --;
        }

        System.out.println("현재 온도 : " + windStrength);
    }


}
