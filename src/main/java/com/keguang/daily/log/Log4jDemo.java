package com.keguang.daily.log;

import org.apache.log4j.Logger;

/**
 * @version v1.0.0
 * @Author:keguang
 * @Date:2018/7/23 17:21
 */
public class Log4jDemo {
    private static Logger logger = Logger.getLogger(Log4jDemo.class);

    private static Logger logger2 = Logger.getLogger("MAIL");

    public static void main(String[] args) {
        logger.debug("this is debug message.");
        logger.info("this is inro message.");
        // logger.error("this is error message.");

        try{
            Integer.valueOf("哈哈");
        }catch (Exception e){
            logger2.error(e);
        }
    }
}
