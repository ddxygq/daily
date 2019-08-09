package com.keguang.daily.schedule;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @ Author: keguang
 * @ Date: 2019/8/9 14:16
 * @ version: v1.0.0
 * @ description:
 */
public class ScheduleDemo {
    public static void main(String[] args) throws SchedulerException {

        // 1 获得一个scheduler
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler scheduler = sf.getScheduler();

        // 2 获得一个jobDetail
        JobDetail job = JobBuilder.newJob(MyJob.class)
                .withIdentity("myjob")
                .build();

        // 3 获得一个trigger
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger", "group")
                .startNow()
                /*.withSchedule(SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(5)
                .withRepeatCount(10))*/
                .withSchedule(CronScheduleBuilder.cronSchedule("*/5 * * * * ?"))
                .build();
        // 4 把任务和触发器放到scheduler中
        scheduler.scheduleJob(job, trigger);

        // 5 开始任务调度
        scheduler.start();

    }
}
