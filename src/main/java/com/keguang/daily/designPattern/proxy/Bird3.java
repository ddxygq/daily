package com.keguang.daily.designPattern.proxy;

/**
 * @ Author: keguang
 * @ Date: 2019/11/20 19:52
 * @ version: v1.0.0
 * @ description:
 */
public class Bird3 implements Flyable{
    private Bird bird;

    public Bird3(Bird bird){
        this.bird = bird;
    }

    @Override
    public void fly() {
        long start = System.currentTimeMillis();
        bird.fly();
        long end = System.currentTimeMillis();
        System.out.println("Fly time = " + (end - start));
    }


}
