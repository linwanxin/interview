package com.yulenka.interview.gc;

/**
 * @Descripiton:
 * @Author:linwx
 * @Date；Created in 17:33 2019/7/17
 **/
public class Finalization {

    public static Finalization finalization;


    @Override
    protected void finalize() {
        System.out.println("Finalized");
        finalization = this;
    }

    public static void main(String[] args) {
        Finalization f = new Finalization();
        System.out.println("First print:" + f);
        f = null;
        System.gc();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Second print : " + f);
        System.out.println(f.finalization);
    }
}
