package com.keguang.daily.designPattern.observer.callback;

/**
 * @ Author: keguang
 * @ Date: 2019/11/28 10:16
 * @ version: v1.0.0
 * @ description:
 */
public class CallbackMain {

    public static void main(String[] args) {
        XiaoMing xiaoMing = new XiaoMing();
        MomCallbackImpl momCallback = new MomCallbackImpl();

        momCallback.say(xiaoMing, "妈妈说：叫你爸回来吃饭");

        // 触发回调
        xiaoMing.wordDown("小明说：我爸爸回来了");
    }
}
