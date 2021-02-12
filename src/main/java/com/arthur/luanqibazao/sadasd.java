package com.arthur.luanqibazao;

import java.io.File;

public class sadasd {

    public static void printDir3(File dir){
// lambda的改写
//        File[] files = dir.listFiles((f) ‐> {
//            return f.getName().endsWith(".java")||f.isDirectory();
//        });
        File[] files = dir.listFiles(f ->  f.getName().endsWith(".java") || f.isDirectory());
// 循环打印
        for(File file:files){
            if(file.isFile()){
                System.out.println("文件名:"+file.getAbsolutePath());
            }else{
                printDir3(file);
            }
        }
    }

    public static void main(String[] args) {
        printDir3(new File("."));
    }
}
