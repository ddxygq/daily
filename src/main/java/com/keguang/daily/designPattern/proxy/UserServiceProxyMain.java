package com.keguang.daily.designPattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @ Author: keguang
 * @ Date: 2019/11/21 17:44
 * @ version: v1.0.0
 * @ description:
 */
public class UserServiceProxyMain {
    public static void main(String[] args) {

        // 1. 创建被代理的对象，即UserService的实现类
        UserServiceImpl userServiceImpl = new UserServiceImpl();

        // 2. 获取对应的classLoader
        ClassLoader classLoader = userServiceImpl.getClass().getClassLoader();

        // 3. 获取所有接口的Class, 这里的userServiceImpl只实现了一个接口UserService，
        Class[] interfaces = userServiceImpl.getClass().getInterfaces();

        // 4. 创建一个将传给代理类的调用请求处理器，处理所有的代理对象上的方法调用
        //     这里创建的是一个自定义的日志处理器，须传入实际的执行对象 userServiceImpl
        InvocationHandler logHandler = new LogHandler(userServiceImpl);

        /*
		   5.根据上面提供的信息，创建代理对象 在这个过程中，
               a.JDK会通过根据传入的参数信息动态地在内存中创建和.class 文件等同的字节码
               b.然后根据相应的字节码转换成对应的class，
               c.然后调用newInstance()创建代理实例
		 */

        // 会动态生成UserServiceProxy代理类，并且用代理对象实例化LogHandler，调用代理对象的.invoke()方法即可
        UserService proxy = (UserService) Proxy.newProxyInstance(classLoader, interfaces, logHandler);

        // 调用代理的方法
        proxy.select();
        proxy.update();

        ProxyUtils.generateClassFile(userServiceImpl.getClass(), "UserServiceJDKProxy");


    }
}
