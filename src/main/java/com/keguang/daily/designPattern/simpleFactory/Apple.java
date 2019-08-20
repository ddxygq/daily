package com.keguang.daily.designPattern.simpleFactory;

/**
 * @ Author: keguang
 * @ Date: 2019/8/14 16:29
 * @ version: v1.0.0
 * @ description:
 */
public class Apple implements Fruit {
    @Override
    public void grow() {
        System.out.println("apple.grow()");
    }

    @Override
    public void harveset() {
        System.out.println("apple.harveset()");
    }

    @Override
    public void plant() {
        System.out.println("apple.plant()");
    }
}
