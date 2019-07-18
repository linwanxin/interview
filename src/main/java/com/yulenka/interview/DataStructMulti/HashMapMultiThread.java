package com.yulenka.interview.DataStructMulti;

import java.util.HashMap;
import java.util.Map;

/**
 * @Descripiton:hashMap在并发下的出错，在4核下CPU不到50%，出现被覆盖的情况到不了10W，
 * 加到15W直接出现报错！
 * @Author:linwx
 * @Date；Created in 20:54 2019/6/24
 **/
public class HashMapMultiThread {
    static Map<String,String> map = new HashMap<>();
    public static class AddThread implements Runnable{

        int start = 0;
        public AddThread(int start){
            this.start = start;
        }
        @Override
        public void run() {

            for(int i=start;i<150000;i+=2){
                map.put(Integer.toString(i),Integer.toBinaryString(i));
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new AddThread(0));
        Thread t2 = new Thread(new AddThread(1));

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(map.size());
    }
}
