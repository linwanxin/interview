package com.yulenka.interview.gc;

/**
 * @Descripiton:
 * @Author:linwx
 * @Date；Created in 16:03 2019/7/16
 **/
public class ReferenceCountingGC {
    public Object instance = null;
    private static final  int _1MB = 1024 * 1024;
    private byte[] bigSize = new byte[2 * _1MB];
    public static void testGC(){
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB =  new ReferenceCountingGC();

        objA.instance = objB;
        objB.instance = objA;



        objA = null;
        objB = null;
        System.gc();
    }
//    private static final long MILLIS_PER_DAY
//            = 24 * 60 * 60 * 1000;
//
//    private static final long MICROS_PER_DAY
//            = 24 * 60 * 60 * 1000 * 1000;
    public static void main(String[] args) {
        testGC();
//        System.out.println(3|9);
//
//        System.out.println(MICROS_PER_DAY / MILLIS_PER_DAY);
//
//        System.out.println(MILLIS_PER_DAY);
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Long.MAX_VALUE);
//        System.out.println(MICROS_PER_DAY);


    }


}
