package com.yulenka.interview.thread;

import java.util.concurrent.Callable;

/**
 * @Descripiton:
 * @Author:linwx
 * @Date；Created in 10:54 2019/7/18
 **/
public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        String value = "test";
        System.out.println("Ready to work");
        Thread.sleep(5000);
        System.out.println("task done");
        return value;
    }
}
