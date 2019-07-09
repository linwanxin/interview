package com.yulenka.interview.reflect;

/**
 * @Descripiton:
 * @Author:linwx
 * @Date；Created in 10:12 2019/7/9
 **/
public class Credit {
    private String name;

    public void sayHello(String msg){
        System.out.println(msg +  name);
    }

    private String throwHello(String msg){
        return "hello " + msg;
    }


}
