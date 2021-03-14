package com.arthur.synchronizedTest;

/**
 * @title: PrintThread
 * @Author ArthurJi
 * @Date: 2021/3/14 19:12
 * @Version 1.0
 */
public class PrintThread implements Runnable{

    int num = 1000;

    @Override
    public void run() {
        while(num > 0) {
            synchronized (this) {
                System.out.println(num);
                num--;
                this.notify();
                try {
                    Thread.sleep(100);
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        PrintThread printThread = new PrintThread();
        new Thread(printThread, "Thread1").start();
        new Thread(printThread, "Thread2").start();

    }
}
