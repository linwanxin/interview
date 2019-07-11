package com.yulenka.interview.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Descripiton:
 * @Author:linwx
 * @Date；Created in 15:40 2019/6/26
 **/
public class IOServer  {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(2222);

        new Thread(()->{
            //为每个连接创建1个请求！
            while (true){
                try {
                    //阻塞方法获取新的连接
                   Socket socket = serverSocket.accept();
                    new Thread(()->{
                        try{
                            int len ;
                            byte[] data = new byte[1024];
                            InputStream inputStream = socket.getInputStream();
                            while ((len = inputStream.read(data)) != 1 ){
                                System.out.println(new String(data,0,len));
                            }
                        }catch (IOException e){

                        }
                    }).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
}
