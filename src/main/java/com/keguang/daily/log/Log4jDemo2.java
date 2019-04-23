package com.keguang.daily.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ Author: keguang
 * @ Date: 2019/2/20 9:53
 * @ version: v1.0.0
 * @ description:
 */
public class Log4jDemo2 {
    public static void main(String[] args) {
        Logger log = LoggerFactory.getLogger(Log4jDemo2.class);
        log.info("this mesage contains {} placeholders .{}", 2, "Yippie");
    }
}
