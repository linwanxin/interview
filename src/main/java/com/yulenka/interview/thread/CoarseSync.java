package com.yulenka.interview.thread;

/**
 * @Descripiton:
 * @Author:linwx
 * @Date；Created in 19:23 2019/7/19
 **/
public class CoarseSync {

    //锁的粗化:不再对每个append方法都要加锁，而是1次枷锁100次！
    public static String copyString100Times(String target){
        int i = 0;
        StringBuffer sb = new StringBuffer();

        while (i < 100){
            sb.append(target);
        }
        return sb.toString();
    }

}
