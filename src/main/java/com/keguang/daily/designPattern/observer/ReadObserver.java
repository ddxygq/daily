package com.keguang.daily.designPattern.observer;

/**
 * @ Author: keguang
 * @ Date: 2019/11/28 10:44
 * @ version: v1.0.0
 * @ description: 微信用户
 */
public class ReadObserver implements IObserver{

    // 用户
    private String name;

    public ReadObserver(String name){
        this.name = name;
    }

    @Override
    public void receiveContent(String info) {
        System.out.println(name + "注意，发送了文章" + info);
    }

    public String getName(){
        return this.name;
    }
}
