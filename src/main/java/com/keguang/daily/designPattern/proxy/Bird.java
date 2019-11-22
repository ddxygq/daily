package com.keguang.daily.designPattern.proxy;

import java.util.Random;

/**
 * @ Author: keguang
 * @ Date: 2019/11/20 19:49
 * @ version: v1.0.0
 * @ description:
 */
public class Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("Bird is flying...");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
