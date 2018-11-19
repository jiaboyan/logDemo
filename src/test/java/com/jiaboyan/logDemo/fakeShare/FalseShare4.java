package com.jiaboyan.logDemo.fakeShare;

/**
 * Created by jiaboyan on 2017/7/8.
 */
public class FalseShare4 implements Runnable {

        public static int NUM_THREADS = 4; // change
        public final static long ITERATIONS = 500L * 1000L * 1000L;
        private final int handleArrayIndex;
        private static VolatileLong[] longs;

        public FalseShare4(final int handleArrayIndex) {
            this.handleArrayIndex = handleArrayIndex;
        }

        public static void main(final String[] args) throws Exception {
            Thread.sleep(10000);
            longs = new VolatileLong[NUM_THREADS];
            for (int i = 0; i < longs.length; i++) {
                longs[i] = new VolatileLong();
            }
            final long start = System.nanoTime();
            runTest();
            System.out.println("duration = " + (System.nanoTime() - start));
        }

        private static void runTest() throws InterruptedException {
            Thread[] threads = new Thread[NUM_THREADS];
            for (int i = 0; i < threads.length; i++) {
                threads[i] = new Thread(new FalseShare4(i));
            }
            for (Thread t : threads) {
                t.start();
            }
            for (Thread t : threads) {
                t.join();
            }
        }

        public void run() {
            long i = ITERATIONS + 1;
            while (0 != --i) {
                longs[handleArrayIndex].value = i;
            }
        }

        public final static class VolatileLong {
            public volatile long value = 0L;
//            public long p1, p2, p3, p4, p5, p6; // 注释
        }
}
