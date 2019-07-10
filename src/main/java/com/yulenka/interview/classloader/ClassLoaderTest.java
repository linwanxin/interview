package com.yulenka.interview.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Descripiton:
 * @Author:linwx
 * @Date；Created in 15:35 2019/7/9
 **/
public class ClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        MyClassLoader myClassLoader = new MyClassLoader("E:\\","creditclass");

        //这里是调用
        Class creditClass = myClassLoader.loadClass("Credit");
        System.out.println(creditClass.getClassLoader());
        System.out.println(creditClass.getClassLoader().getParent());
        System.out.println(creditClass.getClassLoader().getParent().getParent());
        System.out.println(creditClass.getClassLoader().getParent().getParent().getParent());

        Method method = creditClass.getDeclaredMethod("sayHello",String.class);
        method.invoke( creditClass.newInstance(),"yulenka ");


    }
}
