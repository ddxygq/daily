package com.keguang.daily.designPattern.observer;

/**
 * @ Author: keguang
 * @ Date: 2019/11/28 10:25
 * @ version: v1.0.0
 * @ description:
 */
public interface IObserver {

    // 观察者收到信息，内容为info
    void receiveContent(String info);

}
