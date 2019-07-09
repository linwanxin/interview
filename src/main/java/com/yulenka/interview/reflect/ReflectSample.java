package com.yulenka.interview.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Descripiton:
 * @Author:linwx
 * @Date；Created in 10:21 2019/7/9
 **/
public class ReflectSample {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class cc = Class.forName("com.yulenka.interview.reflect.Credit");
        Credit credit = (Credit) cc.newInstance();
        System.out.println("class name is :" + cc.getName());
        //获取声明的方法,无论是public还是private,但是不能获取继承和实现的方法
        Method getHello =  cc.getDeclaredMethod("throwHello", String.class);
        //如果是private，必须+这句话
        getHello.setAccessible(true);
        String result = (String) getHello.invoke(credit,"yulenka");
        System.out.println(result);


        Method hello =  cc.getMethod("sayHello", String.class);
        hello.invoke(credit,"welcome ");

        Field name = cc.getDeclaredField("name");
        name.setAccessible(true);
        name.set(credit,"lwx");
        hello.invoke(credit,"welcome ");

        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
    }

}
