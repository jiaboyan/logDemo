package com.jiaboyan.logDemo.test;

//import org.apache.log4j.Logger;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jiaboyan on 2017/5/14.
 */
public class B {

    static Lock lock = new ReentrantLock();

    private static final Condition processorNotifyCondition = lock.newCondition();

    static class Test implements Runnable{
        public void run() {
            if (1< 2)
            {
                lock.lock();
                try
                {
                    while (2 < 3)
                    {
                        System.out.print("等待");
                        processorNotifyCondition.await();
                        System.out.print("唤醒了");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally
                {
                    lock.unlock();
                }
            }
        }
    }

    static class Test2 implements Runnable{
        public void run() {
            lock.lock();
            try
            {
                processorNotifyCondition.signalAll();
            }
            finally
            {
                lock.unlock();
            }
        }
    }

    public static void main(String[] agrs) throws InterruptedException {
        Test test = new Test();
        Test2 test2 = new Test2();
        Thread thread1 = new Thread(test);
        Thread thread2 = new Thread(test2);
        thread1.start();

        Thread.sleep(5000);
        thread2.start();

    }
//    private static Logger log = Logger.getLogger(B.class.getName());
//
//    public String toString() {
//        log.info("[B.toString]");
//        new A();
//        return "[B.toString] finish";
//    }
//
//    public static void main(String[] agrs){
//        new Thread(new Runnable() {
//            public void run() {
//                log.info(new B());
//            }
//        }).start();
//        new A();
//    }

}
