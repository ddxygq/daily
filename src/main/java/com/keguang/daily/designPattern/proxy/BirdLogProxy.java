package com.keguang.daily.designPattern.proxy;

/**
 * @ Author: keguang
 * @ Date: 2019/11/20 20:02
 * @ version: v1.0.0
 * @ description:
 */
public class BirdLogProxy implements Flyable{
    private Flyable flyable;

    public BirdLogProxy(Flyable flyable){
        this.flyable = flyable;
    }

    @Override
    public void fly() {
        System.out.println("Bird fly start...");

        flyable.fly();

        System.out.println("Bird fly end...");
    }
}
