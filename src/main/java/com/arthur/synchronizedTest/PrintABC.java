package com.arthur.synchronizedTest;

/**
 * @title: Printer
 * @Author ArthurJi
 * @Date: 2021/3/14 19:27
 * @Version 1.0
 */
public class PrintABC {

    public static class MyPrinter implements Runnable {
        Object pre;
        Object cur;
        String name;

        public MyPrinter(Object pre, Object cur, String name) {
            this.pre = pre;
            this.cur = cur;
            this.name = name;
        }


        @Override
        public void run() {
            int num = 100;
            while (num > 0) {
                synchronized (pre) {
                    synchronized (cur) {

                        num--;
                        System.out.println(name + " " + num);
                        cur.notify();
                    }
                    try {
//                        Thread.sleep(100);
                        pre.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        三个锁 挺有意思的
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        new Thread(new MyPrinter(c, a, "A"), "thread3").start();
        Thread.sleep(100);//保证初始ABC的启动顺序
        new Thread(new MyPrinter(a, b, "B"), "thread1").start();
        Thread.sleep(100);//保证初始ABC的启动顺序
        new Thread(new MyPrinter(b, c, "C"), "thread2").start();
        Thread.sleep(100);//保证初始ABC的启动顺序
    }
}