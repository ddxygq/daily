package com.keguang.daily.designPattern.proxy;

import java.lang.reflect.Method;

/**
 * @ Author: keguang
 * @ Date: 2019/11/21 15:08
 * @ version: v1.0.0
 * @ description:
 */
public interface InvocationHandler {

    void invoke(Object proxy, Method method, Object[] args);
}
