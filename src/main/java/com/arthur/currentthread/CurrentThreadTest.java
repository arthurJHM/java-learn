package com.arthur.currentthread;

public class CurrentThreadTest {
    public static void main(String[] args) {
        System.out.println("================================CurrentThread==========================================");
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
