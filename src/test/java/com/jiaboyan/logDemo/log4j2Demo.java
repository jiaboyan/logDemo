package com.jiaboyan.logDemo;

//import com.lmax.disruptor.RingBuffer;
//import com.lmax.disruptor.dsl.Disruptor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jiaboyan on 2017/5/7.
 */
public class log4j2Demo {
//    As of version 2.4, Log4J requires Java 7.

//    Log4j version 2.3 and older require Java 6.

//    http://logging.apache.org/log4j/2.x/faq.html


//    1）   src不是classpath,WEB-INF/classes,lib才是classpath，WEB-INF/是资源目录, 客户端不能直接访问。
//
//            2）   WEB-INF/classes目录存放src目录java文件编译之后的class文件，xml、properties等资源配置文件，这是一个定位资源的入口。
//
//            3）   lib和classes同属classpath，两者的访问优先级为: lib>classes。

    private Logger logger = LogManager.getLogger(log4j2Demo.class);

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
    public void test() throws InterruptedException {
        int X_NUM = 100;
        int Y_NUM = 100000;

        long start = System.currentTimeMillis();
        for(int x=0;x<X_NUM;x++) {
            for (int y = 0; y < Y_NUM; y++) {
                logger.info("Info Message!");
            }
        }
        long time = System.currentTimeMillis() - start;
        System.out.print(time);
    }
}