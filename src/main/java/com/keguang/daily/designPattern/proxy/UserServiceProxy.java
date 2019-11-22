package com.keguang.daily.designPattern.proxy;

import java.util.Date;

/**
 * @ Author: keguang
 * @ Date: 2019/11/21 17:21
 * @ version: v1.0.0
 * @ description:
 */
public class UserServiceProxy implements UserService {
    private UserService target;

    public UserServiceProxy(UserService target){
        this.target = target;
    }

    @Override
    public void select() {
        before();
        target.select();
        after();
    }

    @Override
    public void update() {
        before();
        target.update();
        after();
    }

    private void before() {     // 在执行方法之前执行
        System.out.println(String.format("log start time [%s] ", new Date()));
    }
    private void after() {      // 在执行方法之后执行
        System.out.println(String.format("log end time [%s] ", new Date()));
    }
}
