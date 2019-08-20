package com.keguang.daily.designPattern.singleton;

/**
 * @ Author: keguang
 * @ Date: 2019/8/14 17:12
 * @ version: v1.0.0
 * @ description: 懒汉模式，线程不安全
 */
public class LazySingleton {

    private static LazySingleton lazySingleton = null;

    private LazySingleton(){}

    public static LazySingleton getInstance(){
        if(lazySingleton == null){
            lazySingleton = new LazySingleton();
        }

        return lazySingleton;
    }
}
