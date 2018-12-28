package com.keguang.daily.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by 26015 on 2018-07-17.
 */
public class Log4j2Demo {
    private static Logger logger = LogManager.getLogger(Log4j2Demo.class.getSimpleName());

    private static Logger logger2 = LogManager.getLogger("timeout");

    public static void main(String[] args) {
        // -Dlog.path.prefix=D:\logs\test
        for(int i = 0;i < 10;i++){
            if(i % 2 == 0){
                logger.info("i % 2 == 0 : " + i);
            }else if(i % 3 == 0){
                logger.warn("i % 2 == 0 : " + i);
            }else{
                logger.error("i % 2 == 0 : " + i);
            }
            logger2.trace(i);

            // log ERROR级别的日志，与log.error()效果一样
            // logger.log(Level.ERROR,i);
        }
    }
}
