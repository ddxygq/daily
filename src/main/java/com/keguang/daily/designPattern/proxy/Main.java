package com.keguang.daily.designPattern.proxy;

/**
 * @ Author: keguang
 * @ Date: 2019/11/21 15:41
 * @ version: v1.0.0
 * @ description:
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Object object = Proxy.newProxyInstance(Flyable.class, new MyInvocationHandler(new Bird()));
        System.out.println(object.getClass().getSimpleName());
        ((Flyable)object).fly();
    }
}
