package com.keguang.daily.javabasic;

/**
 * @ Author: keguang
 * @ Date: 2019/1/24 14:20
 * @ version: v1.0.0
 * @ description:
 */
public class ThreadReSort {
    int a = 0;
    boolean flag = false;

    public void writer(){
        a = 1;
        flag = true;
    }

    public void read(){
        if(flag){
            int i = a + 1;
        }
    }

    /**
     * 如上述代码，同时存在线程A和线程B对该实例对象进行操作，其中A线程调用写入方法，而B线程调用读取方法，由于指令重排等原因，可能导致程序执行顺序变为如下：
     *
     * 线程A                    线程B
     writer：                 read：
     1:flag = true;           1:flag = true;
     2:a = 1;                 2: a = 0 ; //误读
     3: i = 1 ;
     */
}
