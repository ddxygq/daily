package com.keguang.daily.designPattern.proxy.cglib;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * @ Author: keguang
 * @ Date: 2019/11/22 17:38
 * @ version: v1.0.0
 * @ description:
 */
public class DaoFilter implements CallbackFilter{
    @Override
    public int accept(Method method) {
        if("select".equals(method.getName())){
            return 0;
        }

        return 1;
    }
}
