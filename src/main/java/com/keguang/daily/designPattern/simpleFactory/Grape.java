package com.keguang.daily.designPattern.simpleFactory;

/**
 * @ Author: keguang
 * @ Date: 2019/8/14 16:31
 * @ version: v1.0.0
 * @ description:
 */
public class Grape implements Fruit {
    @Override
    public void grow() {
        System.out.println("grape.grow()");
    }

    @Override
    public void harveset() {
        System.out.println("grape.harveset()");
    }

    @Override
    public void plant() {
        System.out.println("grape.plant()");
    }
}
