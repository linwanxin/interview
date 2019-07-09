package com.yulenka.interview.callback;

/**
 * @Descripiton:
 * @Author:linwx
 * @Date；Created in 14:42 2019/6/26
 **/
public class Lin implements CallBack {

    //持有B的引用
    private Li li;

    public Lin(Li li) {
        this.li = li;
    }

    public void askQuestion(String question){
        //单独开线程进行异步回调
        new Thread(new Runnable() {
            @Override
            public void run() {
                //调用小李的方法
                li.execQuestion(Lin.this,question);
            }
        }).start();
        //做其他事情
        System.out.println("打球去了...");
    }

    @Override
    public void solve(String result) {
        System.out.println("小李告诉我的答案： " + result);
    }

    //同步回调！
    public void askQuestion2(String question2){
        li.execQuestion(this,question2);
        System.out.println("好的，知道了，88");
    }

    public static void main(String[] args) {
        Lin lin = new Lin(new Li());
        //lin.askQuestion("1+1 = ");
        lin.askQuestion2("1+1 = 2的第2个版本");
    }
}
