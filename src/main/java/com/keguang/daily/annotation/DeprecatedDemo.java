package com.keguang.daily.annotation;

/**
 * @ Author: keguang
 * @ Date: 2019/9/26 13:58
 * @ version: v1.0.0
 * @ description:
 */
public class DeprecatedDemo {

    @Deprecated
    public void hello(){
        System.out.println("hello 1949");
    }

    public void hi(){
        System.out.println("hi 2019");
    }

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        DeprecatedDemo demo = new DeprecatedDemo();
        demo.hello();
        demo.hi();
    }

}
