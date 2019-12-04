package com.keguang.daily.designPattern.observer.callback;

/**
 * @ Author: keguang
 * @ Date: 2019/11/28 10:11
 * @ version: v1.0.0
 * @ description:
 */
public class XiaoMing {

    private ICallback iCallback;

    public void work(ICallback iCallback, String str){
        this.iCallback = iCallback;
        System.out.println(str);
        System.out.println("小明说：收到马上过去，过了半个小时");
    }

    // 小明把事情做完，要给妈妈一个反馈
    public void wordDown(String str){
        if(iCallback != null){
            iCallback.setResult(str);
        }
    }
}
