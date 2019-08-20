package com.keguang.daily.designPattern.singleton;

/**
 * @ Author: keguang
 * @ Date: 2019/8/14 17:20
 * @ version: v1.0.0
 * @ description: 双重锁
 */
public class DoubleCheckSingleton {

    private static DoubleCheckSingleton doubleCheckSingleton = null;
    private static volatile Object o;

    private DoubleCheckSingleton(){}

    public static DoubleCheckSingleton getInstance() {
        if(doubleCheckSingleton == null){
            synchronized (o){
                if(doubleCheckSingleton == null){
                    doubleCheckSingleton = new DoubleCheckSingleton();
                }
            }
        }

        return doubleCheckSingleton;
    }
}
