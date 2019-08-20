package com.keguang.daily.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @ Author: keguang
 * @ Date: 2019/8/20 10:30
 * @ version: v1.0.0
 * @ description:
 */
public class TimerDemo {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        }, 1000);
    }
}
