package com.jiaboyan.logDemo;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

/**
 * Created by jiabo on 2016/6/29.
 * slf4j+logback
 */
public class logbackDemo {

    Logger logger =  LoggerFactory.getLogger(logbackDemo.class);

    @Test
    public void testThread() throws InterruptedException {
        int THREAD_NUM = 100;
        final int LOOP_NUM = 100000;
        final CountDownLatch countDownLatch = new CountDownLatch(THREAD_NUM);
        long start = System.currentTimeMillis();
        for(int x= 0;x < THREAD_NUM;x++){
            new Thread(new Runnable() {
                public void run() {
                    for (int y = 0; y < LOOP_NUM; y++) {
                        logger.info("Info Message!");
                    }
                    countDownLatch.countDown();
                }
            }).start();
        }
        countDownLatch.await();
        long time = System.currentTimeMillis() - start;
        System.out.println(time);
    }

    @Test
    public void test() {
        int X_NUM = 100;
        int Y_NUM = 100000;
        long start = System.currentTimeMillis();
        for(int x=0;x<X_NUM;x++) {
            for (int y = 0; y < Y_NUM; y++) {
                logger.info("Info Message!");
            }
        }
        System.out.print(System.currentTimeMillis()-start);
    }
}
