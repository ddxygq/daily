package com.keguang.daily.designPattern.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * @ Author: keguang
 * @ Date: 2019/11/22 10:23
 * @ version: v1.0.0
 * @ description:
 */
public class LogInterceptor implements MethodInterceptor{

    /*
     * @param o 要进行增强的对象
     * @param method 要拦截的方法
     * @param objects 参数列表，基本数据类型需要传入其包装类
     * @param methodProxy 对方法的代理，
     * @return 执行结果
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(o, objects);
        after();
        return result;

    }

    private void before() {
        System.out.println(String.format("log start time [%s] ", new Date()));
    }
    private void after() {
        System.out.println(String.format("log end time [%s] ", new Date()));
    }
}
