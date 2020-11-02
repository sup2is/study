package me.sup2is;

public class MyObject {
    int count = 0;

    static int staticCnt = 0;

    //thread-safe 하지 않음!
    public void increaseCnt() {
        this.count ++;
    }

    //instance method에 synchronized 추가
    public synchronized void increaseCntWithSynchronized() {
        this.count ++;
    }

    //static method에 synchronized 추가
    public static synchronized void increaseCntWithStaticSynchronized() {
        staticCnt ++;
    }

    //instance method 내부에 synchronized block 추가
    public synchronized void increaseCntWithStaticBlock() {
        synchronized (this) {
            this.count ++;
            synchronized (this) {
                System.out.println("연속적으로 lock 획득 가능" + count);
            }
        }
    }

    public int getCount() {
        return count;
    }

    public static int getStaticCnt() {
        return staticCnt;
    }

    @Override
    public String toString() {
        return "MyObject{" +
            "count=" + count +
            '}';
    }
}