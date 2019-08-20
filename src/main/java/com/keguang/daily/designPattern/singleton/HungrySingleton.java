package com.keguang.daily.designPattern.singleton;

/**
 * @ Author: keguang
 * @ Date: 2019/8/14 17:10
 * @ version: v1.0.0
 * @ description: 单例模式-饿汉式 ： 线程安全
 * 虚拟机遇到一条new指令，首先去检查这个指令的参数能否在常量池中定位到一个类的符号引用，
 * 并且检查这个符号引用代表的类是否已经被加载、解析和初始化。如果没有，那么必须先执行类的初始化过程。
 */
public class HungrySingleton {

    private static HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton(){}

    public static HungrySingleton getInstance(){
        return hungrySingleton;
    }
}
