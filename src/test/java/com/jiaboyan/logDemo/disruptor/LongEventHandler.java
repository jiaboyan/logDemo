package com.jiaboyan.logDemo.disruptor;


import com.lmax.disruptor.EventHandler;

/**
 * Created by jiaboyan on 2017/6/8.
 */
public class LongEventHandler implements EventHandler<LongEvent> {

    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
        Thread.sleep(5000000);
        System.out.println("Event："+event.getValue());
    }
}
