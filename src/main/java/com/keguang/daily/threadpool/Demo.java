package com.keguang.daily.threadpool;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ Author: keguang
 * @ Date: 2019/8/15 14:43
 * @ version: v1.0.0
 * @ description:
 */
public class Demo {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        final List<Integer> l = new LinkedList<>();
        ThreadPoolExecutor tp = new ThreadPoolExecutor(100, 100, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(20000));
        final Random random = new Random();
        for(int i = 0; i < 20000; i++){
            tp.execute(new Runnable() {
                @Override
                public void run() {
                    l.add(random.nextInt());
                }
            });
        }
        tp.shutdown();

        try {
            tp.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(System.currentTimeMillis() - startTime);
        System.out.println(l.size());

        // 结果
        //43
        //19983


    }
}
