package com.keguang.daily.jdbc.spi;

/**
 * @ Author: keguang
 * @ Date: 2019/11/14 15:58
 * @ version: v1.0.0
 * @ description:
 */
public class SpiServiceB implements SpiService{

    @Override
    public void hello() {
        System.out.println("SpiServiceB.hello().");
    }

}
