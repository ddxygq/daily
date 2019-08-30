package com.keguang.daily.future;

import java.util.concurrent.*;

/**
 * @ Author: keguang
 * @ Date: 2019/8/29 13:57
 * @ version: v1.0.0
 * @ description:
 */
public class FutureTaskDemo {

    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();
        Task task = new Task();
        FutureTask<Integer> futureTask = new FutureTask<>(task);
         executorService.submit(futureTask);
        executorService.shutdown();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("主线程在执行任务");
        try {
            System.out.println("task运行结果" + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("所有任务执行完毕");

        new Thread(futureTask).start();

    }
}
