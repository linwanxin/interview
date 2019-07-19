package com.yulenka.interview.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Descripiton:
 * @Author:linwx
 * @Date；Created in 11:50 2019/7/18
 **/
public class FutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<>(new MyCallable());
        new Thread(task).start();
        if(!task.isDone()){
            System.out.println("task has not finished,please wait!");
        }
        System.out.println("task return :" + task.get());


    }
}
