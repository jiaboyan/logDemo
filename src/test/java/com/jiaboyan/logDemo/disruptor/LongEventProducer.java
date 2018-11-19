package com.jiaboyan.logDemo.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.sun.corba.se.impl.ior.ByteBuffer;

/**
 * Created by jiaboyan on 2017/6/8.
 */
public class LongEventProducer {

    private final RingBuffer<LongEvent> ringBuffer;

    public LongEventProducer(RingBuffer<LongEvent> ringBuffer){
        this.ringBuffer = ringBuffer;
    }

    public void onData(long x){
        long sequence = ringBuffer.next();

        try{
            LongEvent longEvent = ringBuffer.get(sequence);
            longEvent.setValue(x);

        }catch (Exception exception){

        }finally {
            ringBuffer.publish(sequence);
        }
    }
}
