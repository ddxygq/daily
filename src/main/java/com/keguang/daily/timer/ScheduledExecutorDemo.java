package com.keguang.daily.timer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @ Author: keguang
 * @ Date: 2019/8/20 10:41
 * @ version: v1.0.0
 * @ description:
 */
public class ScheduledExecutorDemo {

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
        service.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        }, 1, TimeUnit.SECONDS);

    }
}
