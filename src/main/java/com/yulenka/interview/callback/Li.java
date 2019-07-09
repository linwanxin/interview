package com.yulenka.interview.callback;

/**
 * @Descripiton:
 * @Author:linwx
 * @Date；Created in 14:43 2019/6/26
 **/
public class Li {

    //这里很有意思，采用接口声明，注册很多接口！
    public void execQuestion(CallBack callBack,String question){
        System.out.println("小林问的问题是："+ question);

        //计算问题
        for(int i=0;i< 10000;++i);

        //回调小林的方法
        callBack.solve("结果是2");
    }
}
