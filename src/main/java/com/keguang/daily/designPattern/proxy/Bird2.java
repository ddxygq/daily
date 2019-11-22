package com.keguang.daily.designPattern.proxy;

/**
 * @ Author: keguang
 * @ Date: 2019/11/20 19:51
 * @ version: v1.0.0
 * @ description:
 */
public class Bird2 extends Bird{

    @Override
    public void fly() {
        long start = System.currentTimeMillis();
        super.fly();
        long end = System.currentTimeMillis();
        System.out.println("Fly time = " + (end - start));
    }
}
