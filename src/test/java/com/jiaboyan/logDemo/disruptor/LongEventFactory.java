package com.jiaboyan.logDemo.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * Created by jiaboyan on 2017/6/8.
 */
public class LongEventFactory implements EventFactory<LongEvent> {

    public LongEvent newInstance() {
        return new LongEvent();
    }
}
