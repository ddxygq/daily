package com.keguang.daily.designPattern.observer.callback;

/**
 * @ Author: keguang
 * @ Date: 2019/11/28 10:09
 * @ version: v1.0.0
 * @ description:
 */
public class MomCallbackImpl implements ICallback{

    // 让小明去干某些事情
    public void say(XiaoMing xiaoMing, String str){
        xiaoMing.work(this, str);
    }

    // 收到小明的反馈
    @Override
    public void setResult(String str) {
        System.out.println(str);
        eat("妈妈说：好的知道了，洗洗手吃饭吧");

    }

    public void eat(String str){
        System.out.println(str);
    }
}
