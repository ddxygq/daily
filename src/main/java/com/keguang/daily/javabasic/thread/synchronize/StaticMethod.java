package com.keguang.daily.javabasic.thread.synchronize;

/**
 * @ Author: keguang
 * @ Date: 2019/2/14 17:31
 * @ version: v1.0.0
 * @ description:
 */
public class StaticMethod implements Runnable{
    static int i=0;

    /**
     * 作用于静态方法,锁是当前class对象,也就是
     * AccountingSyncClass类对应的class对象
     */
    public static synchronized void increase(){
        i++;
    }

    /**
     * 非静态,访问时锁不一样不会发生互斥
     */
    public synchronized void increase4Obj(){
        i++;
    }

    @Override
    public void run() {
        for(int j=0;j<1000000;j++){
            increase(); // 结果i 是2000000
            // increase4Obj(); // 结果i 1214475
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new StaticMethod());
        Thread t2 = new Thread(new StaticMethod());

        // 启动线程
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(i);
    }
}
