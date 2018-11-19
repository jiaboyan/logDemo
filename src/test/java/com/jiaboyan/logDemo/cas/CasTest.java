package com.jiaboyan.logDemo.cas;

import sun.misc.Unsafe;

/**
 * Created by jiaboyan on 2017/7/9.
 */
public class CasTest implements Runnable{

    private int memoryValue = 1;

    private int expectValue;

    private int updateValue;

    public CasTest(int expectValue,int updateValue){
        this.expectValue = expectValue;
        this.updateValue = updateValue;
    }

    public void run() {
        if(memoryValue==expectValue){
            this.memoryValue = updateValue;
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }
    }

    public static void main(String[] agrs) throws InterruptedException {
        CasTest casTest1 = new CasTest(1,2);
        Thread t1 = new Thread(casTest1);
        t1.start();

        Thread t2= new Thread(casTest1);
        t2.start();

        t1.join();
        t2.join();
    }
}
