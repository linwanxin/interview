package com.yulenka.interview.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Descripiton:
 * @Author:linwx
 * @Date；Created in 15:25 2019/7/18
 **/
public class ThreadPoolDemo {

    public static void main(String[] args) {

        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();

        Future<String> future =  newCachedThreadPool.submit(new MyCallable());

        if(! future.isDone()){
            System.out.println("task has not finished,please wait!");
        }
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            newCachedThreadPool.shutdown();
        }

    }
}
