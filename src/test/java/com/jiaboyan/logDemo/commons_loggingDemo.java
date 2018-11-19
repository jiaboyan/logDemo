package com.jiaboyan.logDemo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by jiabo on 2016/6/29.
 */
public class commons_loggingDemo {

    Log log= LogFactory.getLog(commons_loggingDemo.class);

    @Test
    public void test() throws IOException {
        log.debug("Debug info.");
        log.info("Info info");
        log.warn("Warn info你好");
        log.error("Error info");
        log.fatal("Fatal info");
    }
}
