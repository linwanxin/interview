package com.yulenka.interview.DataStructMulti;

import java.util.ArrayList;

/**
 * @Descripiton:并发问题下的arrayList
 * @Author:linwx
 * @Date；Created in 20:31 2019/6/24
 **/
public class ArrayListMultiThread implements Runnable{
   static ArrayList<Integer> arrayList = new ArrayList<>();


        @Override
        public void run() {
            for(int i=0;i< 100000;++i){
                arrayList.add(i);
            }
        }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new ArrayListMultiThread());
        Thread t2 = new Thread(new ArrayListMultiThread());

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(ArrayListMultiThread.arrayList.size());
    }

}
