package com.keguang.daily.timer;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.Timer;
import io.netty.util.TimerTask;

import java.util.concurrent.TimeUnit;


/**
 * @ Author: keguang
 * @ Date: 2019/8/20 10:49
 * @ version: v1.0.0
 * @ description:
 */
public class HashedWheelTimerDemo {

    public static void main(String[] args) {
        // 默认轮询时间100ms，512个bucket
        Timer timer = new HashedWheelTimer();
        timer.newTimeout(new TimerTask() {
            @Override
            public void run(Timeout timeout) throws Exception {
                System.out.println("hello");
            }
        }, 1, TimeUnit.SECONDS);
    }

}
