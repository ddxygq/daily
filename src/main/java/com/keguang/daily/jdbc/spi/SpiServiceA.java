package com.keguang.daily.jdbc.spi;

/**
 * @ Author: keguang
 * @ Date: 2019/11/14 15:56
 * @ version: v1.0.0
 * @ description:
 */
public class SpiServiceA implements SpiService{

    @Override
    public void hello() {
        System.out.println("SpiServiceA.hello().");
    }
}
