//package com.jiaboyan.logDemo;
//
//import org.apache.log4j.Logger;
//
///**
// * Created by jiaboyan on 2017/5/13.
// */
//public class ThreadLog4jTest implements Runnable {
//    Logger log = Logger.getLogger(log4jDemo.class);
//    public void run() {
//        long start = System.currentTimeMillis();
//        for(int y=0;y<10000;y++){
//            log.info("Info Message!");
//        }
//        long time = System.currentTimeMillis() - start ;
//        System.out.println(time);
//    }
//}
