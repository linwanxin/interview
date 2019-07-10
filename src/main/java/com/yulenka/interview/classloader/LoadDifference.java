package com.yulenka.interview.classloader;

/**
 * @Descripiton:
 * @Author:linwx
 * @Date；Created in 10:09 2019/7/10
 **/
public class LoadDifference {
    public static void main(String[] args) throws ClassNotFoundException {
        //ClassLoader classLoader = Robot.class.getClassLoader();

        Class Robot =  Class.forName("com.yulenka.interview.classloader.Robot");
    }
}
