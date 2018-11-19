package com.jiaboyan.logDemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by jiaboyan on 2017/5/3.
 */
public class log4j2Test {

    private static Logger logger = LogManager.getLogger(log4j2Test.class);

    public static void main(String[] agrs){
        logger.debug("我的名字:{}","jiaboyan");
    }
}
