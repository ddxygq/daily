package com.keguang.daily.designPattern.proxy;

import org.junit.Test;

/**
 * @ Author: keguang
 * @ Date: 2019/11/20 19:57
 * @ version: v1.0.0
 * @ description:
 */
public class ProxyTests {

    @Test
    public void test(){
        Bird2 bird2 = new Bird2();
        bird2.fly();
    }

    @Test
    public void test2(){
        Bird bird = new Bird();
        BirdTimeProxy birdTimeProxy = new BirdTimeProxy(bird);
        BirdLogProxy birdLogProxy = new BirdLogProxy(birdTimeProxy);
        birdLogProxy.fly();
    }
}
