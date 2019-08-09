package com.keguang.daily.schedule;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @ Author: keguang
 * @ Date: 2019/8/9 14:11
 * @ version: v1.0.0
 * @ description:
 */
public class MyJob implements Job {

    private static int s = 0;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        // System.out.println("this is my schedule job." + ++s);
        System.out.println(System.currentTimeMillis());
    }
}
