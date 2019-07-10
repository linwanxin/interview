package com.yulenka.interview.classloader;

import java.io.*;

/**
 * @Descripiton:
 * @Author:linwx
 * @Date；Created in 15:23 2019/7/9
 **/
public class MyClassLoader  extends ClassLoader {
    private String path;
    private String className;

    public MyClassLoader(String path, String className) {
        this.path = path;
        this.className = className;
    }

    public Class findClass(String name){
        byte[] b =  loadClassData(name);
        return defineClass(name,b,0,b.length);
    }

    private byte[] loadClassData(String name) {
        name = path + name + ".class";
        InputStream in = null;
        ByteArrayOutputStream out = null;
        try{
            in =  new FileInputStream(new File(name));
            out = new ByteArrayOutputStream();
            int i = 0;
            while ((i = in.read()) != -1){
                out.write(i);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return out.toByteArray();
    }



}
