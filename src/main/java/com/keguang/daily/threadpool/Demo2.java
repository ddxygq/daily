package com.keguang.daily.threadpool;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ Author: keguang
 * @ Date: 2019/8/15 14:44
 * @ version: v1.0.0
 * @ description:
 */
public class Demo2 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        final List<Integer> l = new LinkedList<>();
        final Random random = new Random();
        for(int i = 0; i < 20000; i++){
            Thread thread = new Thread(){
                @Override
                public void run(){
                    l.add(random.nextInt());
                }
            };
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(System.currentTimeMillis() - startTime);
        System.out.println(l.size());


        // 结果
        // 2254
        //20000

    }
}
