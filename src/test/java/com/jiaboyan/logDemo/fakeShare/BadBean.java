package com.jiaboyan.logDemo.fakeShare;

/**
 * Created by jiaboyan on 2017/6/10.
 */
public class BadBean implements Runnable{

    long i;

    long j;

    public void run() {
        i++;
        j++;
    }
}
