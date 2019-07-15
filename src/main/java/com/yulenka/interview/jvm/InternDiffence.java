package com.yulenka.interview.jvm;

/**
 * @Descripiton:
 * @Author:linwx
 * @Date；Created in 22:57 2019/7/15
 **/
public class InternDiffence {

    /**
     * 很有意思的现象，：DK1.8竟然会出现不同的结果；
     * 对于JDK1.6和1.8也会有不同的结果；
     * 解释：new里面的a会先创建字符串到常量池，s1.intern()会拷贝副本到常量池，但是已有；s2指向！
     * 1.8以后会放引用进去！
     * @param args
     */
    public static void main(String[] args) {

        String s1 = new String("a");
        s1.intern();//这里是放引用，会放不进去的，因为存在了！
        String s2 = "a";
        System.out.println(s1 == s2);

        String s3 = new String("a") + new String("a");
        s3.intern();//会把aa的引用放进去，所以会出现相同！
        String s4 = "aa";
        System.out.println(s3 == s4);

    }
}
