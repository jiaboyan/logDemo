package com.jiaboyan.logDemo.fakeShare;

/**
 * Created by jiaboyan on 2017/6/10.
 */
public class GoodBean implements Runnable{

    long i;

    long p1,p2,p3,p4,p5,p6,p7;

    long j;

    public void run() {
        i++;

        j++;
    }
}
