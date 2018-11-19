package com.jiaboyan.logDemo.disruptor;

//import com.lmax.disruptor.RingBuffer;
//import com.lmax.disruptor.dsl.Disruptor;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by jiaboyan on 2017/6/8.
 */
public class DisruptorMain {

    public static void main(String[] agrs) throws InterruptedException {
        Executor executor = Executors.newCachedThreadPool();

        LongEventFactory longEventFactory = new LongEventFactory();

        int bufferSize = 8;

        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(longEventFactory, bufferSize, executor,ProducerType.SINGLE, new BlockingWaitStrategy());

        disruptor.handleEventsWith(new LongEventHandler());

        disruptor.start();

        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        LongEventProducer producer = new LongEventProducer(ringBuffer);

        for (int x=0 ;x<70;x++) {
            if(x==8){
                producer.onData(x);
            }else {
                producer.onData(x);
            }
        }
    }
}
