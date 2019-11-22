package com.keguang.daily.designPattern.proxy.cglib;

/**
 * @ Author: keguang
 * @ Date: 2019/11/22 10:21
 * @ version: v1.0.0
 * @ description:
 */
public class UserDao {

    public void select(){
        System.out.println("UserDao 查询 selectById");
    }

    public void update(){
        System.out.println("UserDao 更新 update");
    }
}
