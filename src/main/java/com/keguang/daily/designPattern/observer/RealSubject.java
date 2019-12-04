package com.keguang.daily.designPattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author: keguang
 * @ Date: 2019/11/28 10:29
 * @ version: v1.0.0
 * @ description:
 */
public class RealSubject implements IWxServerSubject{

    // 订阅者列表，即关注的读者
    private List<IObserver> observers = new ArrayList<>();

    // 作者更新的内容
    private String updateContent;

    @Override
    public void attchObserver(IObserver iObserver) {
        observers.add(iObserver);
    }

    @Override
    public void detachObserver(IObserver iObserver) {
        if(observers.contains(iObserver)){
            observers.remove(iObserver);
        }
    }

    @Override
    public void notifyObserver() {
        for(IObserver iObserver : observers){
            iObserver.receiveContent(updateContent);
        }
    }

    /**
     * 是否关注
     * @param iObserver
     * @return
     */
    public boolean isAttachObserver(IObserver iObserver){
        return observers.contains(iObserver);
    }

    /**
     * 发布文章
     * @param updateContent
     */
    public void submitContent(String updateContent){
        this.updateContent = updateContent;
        this.notifyObserver();
    }
}
