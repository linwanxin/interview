package com.yulenka.interview.jvm;

import java.util.Random;

/**
 * @Descripiton:
 * @Author:linwx
 * @Date；Created in 19:16 2019/7/15
 **/
public class StringTest {
    public static void main(String[] args) {
        test1();
        System.out.println("====分割线======");
        test2();
        System.out.println("====分割线======");
        test3();
        System.out.println("====分割线======");
        permGenErrTest();
    }

    public static void test1(){
        String str1 = "abcd";//先检查字符串常量池中有没有"abcd"，如果字符串常量池中没有，则创建一个，然后 str1 指向字符串常量池中的对象，如果有，则直接将 str1 指向"abcd""；
        String str2 = new String("abcd");//堆中创建一个新的对象
        String str3 = new String("abcd");//堆中创建一个新的对象
        System.out.println(str1==str2);//false
        System.out.println(str2==str3);//false

    }
    public static void test2() {
        String s1  = new String("计算机");
        String s2 = s1.intern();
        String s3 = "计算机";
        System.out.println(s2);//计算机
        System.out.println(s1 == s2);//false，因为一个是堆内存中的 String 对象一个是常量池中的 String 对象，
        System.out.println(s3 == s2);//true，因为两个都是常量池中的 String 对象
    }

    public static void test3() {
        String str1 = "str";
        String str2 = "ing";

        //尽量避免多个字符串拼接，因为这样会重新创建对象。如果需要改变字符串的话，可以使用 StringBuilder 或者 StringBuffer。
        String str3 = "str" + "ing";//常量池中的对象
        String str4 = str1 + str2; //在堆上创建的新的对象
        String str5 = "string";//常量池中的对象
        System.out.println(str3 == str4);//false
        System.out.println(str3 == str5);//true
        System.out.println(str4 == str5);//false
    }


    public static void permGenErrTest(){
        for(int i=0;i<1000;++i){
            getRandomString(1000000).intern();
        }
        System.out.println("Mission Complete!");
    }

    private static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0;i<length;++i){
          int index =  random.nextInt(62);
          stringBuffer.append(str.charAt(index));
        }
        return stringBuffer.toString();
    }


}
