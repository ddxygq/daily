package com.keguang.daily.designPattern.proxy;

/**
 * @ Author: keguang
 * @ Date: 2019/11/20 19:59
 * @ version: v1.0.0
 * @ description:
 */
public class BirdTimeProxy implements Flyable {

    private Flyable flyable;

    public BirdTimeProxy(Flyable flyable){
        this.flyable = flyable;
    }

    @Override
    public void fly() {
        long start = System.currentTimeMillis();
        flyable.fly();
        long end = System.currentTimeMillis();
        System.out.println("Fly time = " + (end - start));
    }
}
