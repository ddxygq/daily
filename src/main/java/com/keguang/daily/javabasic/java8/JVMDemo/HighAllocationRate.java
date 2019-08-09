package com.keguang.daily.javabasic.java8.JVMDemo;

import java.util.concurrent.locks.LockSupport;

/**
 * @ Author: keguang
 * @ Date: 2019/7/22 17:51
 * @ version: v1.0.0
 * @ description:
 */
public class HighAllocationRate implements Runnable{

    private static volatile Double sensorValue;


    @Override
    public void run() {
        while (true){
            sensorValue = Math.random();
        }
    }

    private static void processSensorValue(Double value) {
        // 虽然形参没有真正被赋值给任一引用，但是这里是模拟了外部传入值，这里会进行各种操作
        if (value != null) {
            // Be warned: may take more than one usec on some machines, especially Windows
            LockSupport.parkNanos(1000);
        }
    }

    public static void main(String[] args) {
        int iterations = args.length > 0 ? Integer.parseInt(args[0]) : 30_000_000;

        initSensor();

        for (int i = 0; i < iterations; i++) {
            processSensorValue(sensorValue);
        }
    }

    private static void initSensor() {
        Thread sensorReader = new Thread(new HighAllocationRate());
        // 当主线程结束时守护线程自动结束
        sensorReader.setDaemon(true);
        sensorReader.start();
    }
}
