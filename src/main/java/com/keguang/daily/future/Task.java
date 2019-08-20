package com.keguang.daily.future;

import java.util.concurrent.Callable;

/**
 * @ Author: keguang
 * @ Date: 2019/8/19 17:47
 * @ version: v1.0.0
 * @ description:
 */
public class Task implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("子线程在进行计算");
        Thread.sleep(3000);
        int sum = 0;
        for(int i=0;i<100;i++){
            sum += i;
        }

        return sum;
    }
}
