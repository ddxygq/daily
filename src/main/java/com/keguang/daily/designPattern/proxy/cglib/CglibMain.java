package com.keguang.daily.designPattern.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @ Author: keguang
 * @ Date: 2019/11/22 10:30
 * @ version: v1.0.0
 * @ description:
 */
public class CglibMain {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserDao.class);
        enhancer.setCallback(new LogInterceptor());

        UserDao userDao = (UserDao)enhancer.create();
        userDao.update();
        userDao.select();
    }
}
