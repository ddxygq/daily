package com.keguang.daily.designPattern.observer;

/**
 * @ Author: keguang
 * @ Date: 2019/11/28 10:23
 * @ version: v1.0.0
 * @ description:
 */
public interface IWxServerSubject {

    // 添加观察者
    void attchObserver(IObserver iObserver);

    // 移除观察者
    void detachObserver(IObserver iObserver);

    // 通知观察者
    void notifyObserver();
}
