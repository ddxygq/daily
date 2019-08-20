package com.keguang.daily.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @ Author: keguang
 * @ Date: 2019/8/19 17:44
 * @ version: v1.0.0
 * @ description:
 */
public class CallableFuture {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Task task = new Task();
        Future<Integer> result = executorService.submit(task);
        executorService.shutdown();

        Thread.sleep(1000);

        System.out.println("主线程在执行任务");

        try {
            System.out.println("task执行结果："  + result.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("所有任务执行完毕");

    }
}
