package org.sandbox.config;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: zhangxin
 * Date:   15-9-15
 */
@Component
//@EnableScheduling
public class TaskConfig {
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
    private static int count = 0;

    //fixedRate: 从上一个任务开始到下一个任务开始的间隔，单位是毫秒。
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println("The time is now " + simpleDateFormat.format(new Date()));
    }

    @Scheduled(cron = "0/1 * * * * ?")
    public void repeatShowMsg() {
        System.out.println("repeat show message: " + (++count));
    }

    //fixedDelay: 表示从上一个任务完成开始到下一个任务开始的间隔，单位是毫秒。
    @Scheduled(fixedDelay = 10000)
    public void fixedDelayShowMsg() {
        System.out.println("fixed delay show message ... ");
    }

    @Scheduled(initialDelay = 10000, fixedRate = 6000)
    public void initialDelayShowMsg() {
        System.out.println("initial delay show message!");
    }

    @Scheduled(fixedRateString = "10000")
    public void fixedRateStringShowMsg() {
        System.out.println("fixed rate string show message ... ");
    }

    @Scheduled(fixedDelayString = "10000")
    public void fixedDelayStringShowMsg() {
        System.out.println("fixed delay string show message ...");
    }

    @Scheduled(initialDelayString = "10000", fixedDelayString = "10000")
    public void initialDelayStringShowMsg() {
        System.out.println("initial delay string show message ...");
    }

    @Scheduled(initialDelay = 10000, fixedDelay = Long.MAX_VALUE)
    public void runOnceMsg() {
        System.out.println("only run once message!!");
    }
}
