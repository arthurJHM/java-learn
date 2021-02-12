package com.arthur.luanqibazao;

public class Demo02LambdaRunnable {
    public static void main(String[] args) {
        new Thread(() -> System.out.println("asdasd")).start();
        new Thread(() -> System.out.println("多线程执行")).start();
//        new Thread(()‐> System.out.println("多线程任务执行！"))
//        System.out.println("gkjh");
    }
}