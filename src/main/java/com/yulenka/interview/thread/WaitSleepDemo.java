package com.yulenka.interview.thread;

/**
 * @Descripiton:
 * @Author:linwx
 * @Date；Created in 18:08 2019/7/18
 **/
public class WaitSleepDemo {
    public static void main(String[] args) {
        final Object lock = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread A is waiting to get lock");
                synchronized (lock){
                    try {
                        Thread.sleep(20);
                        System.out.println("thread A do wait method");
                        lock.wait();
                        System.out.println("thread A is done");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread B is waiting to get lock");
                synchronized(lock){
                    try {
                        System.out.println("thread B get lock");
                        System.out.println("thread B is sleeping 10 ms");
                        Thread.sleep(10);
                        lock.notifyAll();//这里唤醒，是把他们放入锁池， 但是还没真正释放锁，只有在synchronized同步块运行出来后才真正释放锁,

                        //看下是否会让出锁！，并不会！依旧是B执行完才会执行A！
                        Thread.yield();
                        Thread.sleep(2000);
                        System.out.println("thread B is done");

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}
