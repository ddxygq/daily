package com.keguang.daily.log;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * @ Author: keguang
 * @ Date: 2018/12/28 9:43
 * @ version: v1.0.0
 * @ description:
 */
public class Log4jDynamicDemo {
    private static Logger logger = LogManager.getLogger(Log4jDynamicDemo.class);

    public static void main(String[] args) {
        logger.info("test");
        logger.warn("warn");
    }
}
