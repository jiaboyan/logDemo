package com.jiaboyan.logDemo.fakeShare;

/**
 * Created by jiaboyan on 2017/6/9.
 */
public class FalseShare2 {

    // 测试用的线程数
    private final static int NUM_THREADS = 4;

    // 测试的次数
    private final static int NUM_TEST_TIMES = 10;

    // 无填充、无缓存行对齐的对象类
    static class Test1 {
        public volatile long value = 0L;
    }

    // 有填充、有缓存行对齐的对象类
    static final class Test2 extends Test1 {

        public long p1, p2, p3, p4, p5, p6;
    }

    static final class Thread1 extends Thread {

        private final static long ITERATIONS = 500L * 1000L * 1000L;

        private Test1 test1;

        public Thread1(final Test1 test1) {
            this.test1 = test1;
        }

        @Override
        public void run() {
            // 一个线程对一个变量进行大量的存取操作
            for (int i = 0; i < ITERATIONS; i++) {
                test1.value = i;
            }
        }
    }



    public static void test1() throws InterruptedException {

        Test1[] test1 = new Test1[4];

        for (int i = 0; i < 4; i++) {
            test1[i] = new Test1();
        }

        Thread1[] thread1 = new Thread1[4];
        for (int i = 0; i < thread1.length; i++) {
            thread1[i] = new Thread1(test1[i]);
        }

        final long start = System.nanoTime();
        for (Thread t : thread1) {
            t.start();
        }

        for (Thread t : thread1) {
            t.join();
        }

        // 统计每次测试使用的时间
        System.out.println(System.nanoTime() - start);
    }

    public static void test2() throws InterruptedException {

        Test2[] test2 = new Test2[4];

        for (int i = 0; i < 4; i++) {
            test2[i] = new Test2();
        }

        Thread1[] thread1 = new Thread1[4];
        for (int i = 0; i < thread1.length; i++) {
            thread1[i] = new Thread1(test2[i]);
        }

        final long start = System.nanoTime();
        for (Thread t : thread1) {
            t.start();
        }

        for (Thread t : thread1) {
            t.join();
        }

        // 统计每次测试使用的时间
        System.out.println(System.nanoTime() - start);
    }

    public static void main(String[] args) throws Exception {

        int expectedCount = 0;

        for (int i = 0; i < 10; i++) {
            test2();
        }
    }








}
