package com.keguang.daily.designPattern.proxy.cglib;

import com.keguang.daily.designPattern.proxy.ProxyUtils;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;

/**
 * @ Author: keguang
 * @ Date: 2019/11/22 17:40
 * @ version: v1.0.0
 * @ description:
 */
public class CglibFilterMain {

    public static void main(String[] args) {
        LogInterceptor logInterceptor = new LogInterceptor();
        LogInterceptor2 logInterceptor2 = new LogInterceptor2();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserDao.class);
        enhancer.setCallbacks(new Callback[]{logInterceptor, logInterceptor2});
        enhancer.setCallbackFilter(new DaoFilter());

        UserDao proxy = (UserDao)enhancer.create();
        proxy.select();
        proxy.update();

        ProxyUtils.generateClassFile(UserDao.class, "UserDaoCglibProxy");

    }
}
