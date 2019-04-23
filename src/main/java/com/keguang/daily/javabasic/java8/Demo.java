package com.keguang.daily.javabasic.java8;

/**
 * @ Author: keguang
 * @ Date: 2019/3/30 16:16
 * @ version: v1.0.0
 * @ description: jdk8 中 接口可以定义默认非抽象方法
 */
public interface Demo {

    double calculate(int a);

    default double sqrt(int a){
        return Math.sqrt(a);
    }
}
