package com.jiaboyan.logDemo.disruptor;

/**
 * Created by jiaboyan on 2017/6/8.
 */
public class LongEvent {

    private long value;

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        System.out.println(value);
        this.value = value;
    }
}
