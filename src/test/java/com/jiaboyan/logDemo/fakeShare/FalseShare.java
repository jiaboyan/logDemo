package com.jiaboyan.logDemo.fakeShare;

/**
 * Created by jiaboyan on 2017/6/9.
 */
public class FalseShare implements Runnable{

    public static class VolatileLong1 {

        public long x = 0L;

        public long p1, p2, p3, p4, p5;

        public long y = 0L;
    }

    private static VolatileLong1[] longs1 = new VolatileLong1[1000000];

    public static class VolatileLong2 {

        public long x = 0L;

        public long y = 0L;
    }
    private static VolatileLong2[] longs2 = new VolatileLong2[1000000];

    static {
        for(int x=0;x<1000000;x++){
            longs1[x] = new VolatileLong1();
            longs2[x] = new VolatileLong2();
        }
    }

    public void run() {
        for(int x = 0;x<1000000;x++){
            longs1[x].x = 1;

            longs1[x].y = 1;
        }
    }

    public static void main(final String[] args) throws Exception {
        final long start = System.nanoTime();

        Thread[] threads = new Thread[4];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new FalseShare());
        }
        for (Thread t : threads) {
            t.start();
        }
        for (Thread t : threads) {
            t.join();
        }
        System.out.println("duration = " + (System.nanoTime() - start));
    }
}
