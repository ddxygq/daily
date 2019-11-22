package com.keguang.daily.designPattern.proxy;

/**
 * @ Author: keguang
 * @ Date: 2019/11/21 17:26
 * @ version: v1.0.0
 * @ description:
 */
public class UserServiceMain {
    public static void main(String[] args) {
        UserService userServiceImpl = new UserServiceImpl();
        UserService proxy = new UserServiceProxy(userServiceImpl);
        proxy.select();
        proxy.update();
    }
}
