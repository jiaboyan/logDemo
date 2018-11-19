//package com.jiaboyan.logDemo;
//
//import org.apache.log4j.FileAppender;
//import org.apache.log4j.Layout;
//
//import java.io.IOException;
//
///**
// * Created by jiaboyan on 2017/5/14.
// */
//public class HookFileAppender extends FileAppender {
//
//    public HookFileAppender(){
//        super();
//        Runtime.getRuntime().addShutdownHook(new Log4jHockThread());
//    }
//
//    public HookFileAppender(Layout layout, String filename) throws IOException {
//        super(layout,filename);
//        Runtime.getRuntime().addShutdownHook(new Log4jHockThread());
//    }
//
//    public HookFileAppender(Layout layout, String filename, boolean append) throws IOException {
//        super(layout,filename,append);
//        Runtime.getRuntime().addShutdownHook(new Log4jHockThread());
//    }
//
//    public HookFileAppender(Layout layout, String filename, boolean append, boolean bufferedIO,
//                 int bufferSize) throws IOException {
//        this.layout = layout;
//        this.setFile(filename, append, bufferedIO, bufferSize);
//    }
//
//
//    class Log4jHockThread extends Thread{
//
//        @Override
//        public void run() {
//            if(qw != null){
//                qw.flush();
//            }
//        }
//    }
//
//}
