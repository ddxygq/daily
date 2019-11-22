package com.keguang.daily.designPattern.proxy;

/**
 * @ Author: keguang
 * @ Date: 2019/11/21 17:20
 * @ version: v1.0.0
 * @ description:
 */
public class UserServiceImpl implements UserService {
    @Override
    public void select() {
        System.out.println("查询 selectById");
    }

    @Override
    public void update() {
        System.out.println("更新 update");
    }
}
