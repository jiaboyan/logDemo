package com.jiaboyan.logDemo.fakeShare;

/**
 * Created by jiaboyan on 2017/7/8.
 */
public class FalseShare3 implements Runnable{

    public static int NUM_THREADS = 4; // change

    public static long ITERATIONS = 500L * 1000L * 1000L;

    private int arrayIndex;

    private static VolatileLong[] longs = new VolatileLong[NUM_THREADS];

    static{
        for (int i = 0; i < longs.length; i++) {
            longs[i] = new VolatileLong();
        }
    }

    public FalseShare3(int arrayIndex) {
        this.arrayIndex = arrayIndex;
    }

    public static void main(final String[] args) throws Exception {
        Thread.sleep(10000);

        long start = System.nanoTime();

        Thread[] threads = new Thread[NUM_THREADS];
        for (int x = 0; x < threads.length; x++) {
            threads[x] = new Thread(new FalseShare3(x));
        }
        for (Thread t : threads) {
            t.start();
        }
        for (Thread t : threads) {
            t.join();
        }
        System.out.println(System.nanoTime() - start);
    }

    public void run() {
        long i = ITERATIONS;
        while (0 != i--) {
            longs[arrayIndex].value = i;
        }
    }

    public static class VolatileLong {
        public long value = 0L;
        public long p1, p2, p3, p4, p5; // 注释
        public int p6;
    }
}
