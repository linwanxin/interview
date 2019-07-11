package com.yulenka.interview.bio;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * @Descripiton:
 * @Author:linwx
 * @Date；Created in 15:37 2019/6/26
 **/
public class IOClient {

    public static void main(String[] args) {
        new Thread(()->{
            try {
                Socket socket = new Socket("127.0.0.1",2222);
                while (true){
                    try{
                        socket.getOutputStream().write((new Date() + ":hello ").getBytes());
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
