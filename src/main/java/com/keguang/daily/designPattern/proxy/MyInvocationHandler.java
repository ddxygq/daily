package com.keguang.daily.designPattern.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ Author: keguang
 * @ Date: 2019/11/21 15:22
 * @ version: v1.0.0
 * @ description:
 */
public class MyInvocationHandler implements InvocationHandler{
    private Bird bird;

    public MyInvocationHandler(Bird bird){
        this.bird = bird;
    }


    @Override
    public void invoke(Object proxy, Method method, Object[] args) {

        long start = System.currentTimeMillis();

        try{
            method.invoke(bird, new Object[]{});
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }catch (InvocationTargetException e){
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("Fly time = " + (end - start));
    }
}
