package com.keguang.daily.designPattern.observer;

/**
 * @ Author: keguang
 * @ Date: 2019/11/28 10:55
 * @ version: v1.0.0
 * @ description:
 */
public class ObserverMain {

    public static void main(String[] args) {
        IWxServerSubject iWxServerSubject = new RealSubject();

        // 微信用户
        ReadObserver zhangsai = new ReadObserver("张三");
        ReadObserver lisi = new ReadObserver("李四");
        ReadObserver wangwu = new ReadObserver("王五");
        ReadObserver zhaoLiu = new ReadObserver("赵六");

        // 关注
        iWxServerSubject.attchObserver(zhangsai);
        iWxServerSubject.attchObserver(lisi);
        iWxServerSubject.attchObserver(wangwu);

        // 我发布了一篇
        ((RealSubject)iWxServerSubject).submitContent("观察者模式.");


    }
}
