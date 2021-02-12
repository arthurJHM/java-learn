package com.arthur.luanqibazao;

import java.io.File;

public class FileFor {
    public static void main(String[] args) {
        File dir = new File("E:\\学习资料\\黑马19年Java全(IDEA)\\03-JavaWeb");
//获取当前目录下的文件以及文件夹的名称。
        String[] names = dir.list();
        for (String name : names) {
            System.out.println(name);
        }
        //获取当前目录下的文件以及文件夹对象，只要拿到了文件对象，那么就可以获取更多信息
        File[] files = dir.listFiles();
        for (File file : files) {
            System.out.println(file);
        }
    }
}