package com.keguang.daily.javabasic.java8;

/**
 * @ Author: keguang
 * @ Date: 2019/3/30 16:18
 * @ version: v1.0.0
 * @ description:
 */
public class DemoMain {

    public static void main(String[] args) {
        Demo demo = new Demo() {
            @Override
            public double calculate(int a) {
                return a + 1;
            }
        };

        System.out.println(demo.calculate(4));
        System.out.println(demo.sqrt(8));
    }
}
