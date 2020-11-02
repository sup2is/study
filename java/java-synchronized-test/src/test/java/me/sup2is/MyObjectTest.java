package me.sup2is;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyObjectTest {

    @BeforeEach
    public void setup() {
        MyObject.staticCnt = 0;
    }

    @RepeatedTest(5)
    public void test_concurrency_not_safe() throws Exception{
        //given
        int numberOfThreads = 1000;
        ExecutorService service = Executors.newFixedThreadPool(numberOfThreads);
        CountDownLatch latch = new CountDownLatch(numberOfThreads);
        MyObject counter = new MyObject();

        //when
        for (int i = 0; i < numberOfThreads; i++) {
            service.execute(() -> {
                counter.increaseCnt();
                latch.countDown();
            });
        }

        //then
        latch.await();
        assertEquals(numberOfThreads, counter.getCount());
    }

    @RepeatedTest(5)
    public void test_concurrency_sync_method() throws Exception{
        //given
        int numberOfThreads = 1000;
        ExecutorService service = Executors.newFixedThreadPool(numberOfThreads);
        CountDownLatch latch = new CountDownLatch(numberOfThreads);
        MyObject counter = new MyObject();

        //when
        for (int i = 0; i < numberOfThreads; i++) {
            service.execute(() -> {
                counter.increaseCntWithSynchronized();
                latch.countDown();
            });
        }

        //then
        latch.await();
        assertEquals(numberOfThreads, counter.getCount());
    }

    @RepeatedTest(5)
    public void test_concurrency_static_sync_method() throws Exception{
        //given
        int numberOfThreads = 1000;
        ExecutorService service = Executors.newFixedThreadPool(numberOfThreads);
        CountDownLatch latch = new CountDownLatch(numberOfThreads);

        //when
        for (int i = 0; i < numberOfThreads; i++) {
            service.execute(() -> {
                MyObject.increaseCntWithStaticSynchronized();
                latch.countDown();
            });
        }

        //then
        latch.await();
        assertEquals(numberOfThreads, MyObject.getStaticCnt());

        MyObject.staticCnt = 0;
    }

    @RepeatedTest(5)
    public void test_concurrency_sync_block() throws Exception{
        //given
        int numberOfThreads = 1000;
        ExecutorService service = Executors.newFixedThreadPool(numberOfThreads);
        CountDownLatch latch = new CountDownLatch(numberOfThreads);
        MyObject counter = new MyObject();

        long start = System.currentTimeMillis();
        //when
        for (int i = 0; i < numberOfThreads; i++) {
            service.execute(() -> {
                counter.increaseCntWithStaticBlock();
                latch.countDown();
            });
        }
        long end = System.currentTimeMillis();
        System.out.println((end - start));

        //then
        latch.await();
        assertEquals(numberOfThreads, counter.getCount());
    }
}