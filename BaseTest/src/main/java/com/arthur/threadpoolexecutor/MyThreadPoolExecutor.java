package com.arthur.threadpoolexecutor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class MyThreadPoolExecutor {
    public static void main(String[] args) {
        System.out.println("================================ThreadPoolExecutor==========================================");
        class MyRunnable implements Runnable {

            private String command;

            public MyRunnable(String s) {
                this.command = s;
            }

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " Start. Time = " + new Date());
                processCommand();
                System.out.println(Thread.currentThread().getName() + " End. Time = " + new Date());
            }

            private void processCommand() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public String toString() {
                return this.command;
            }
        }

        int CORE_POOL_SIZE = 5;
        int MAX_POOL_SIZE = 10;
        int QUEUE_CAPACITY = 100;
        Long KEEP_ALIVE_TIME = 1L;
        java.util.concurrent.ThreadPoolExecutor executor = new java.util.concurrent.ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 10; i++) {
            //创建WorkerThread对象（WorkerThread类实现了Runnable 接口）
            Runnable worker = new MyRunnable("" + i);
            //执行Runnable
            executor.execute(worker);
//            executor.submit(worker);
        }
        //终止线程池
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");



        class MyCallable implements Callable<String> {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                //返回执行当前 Callable 的线程名字
                return Thread.currentThread().getName();
            }
        }

        System.out.println();
        System.out.println();
        System.out.println("***************************************************");

        //使用阿里巴巴推荐的创建线程池的方式
        //通过ThreadPoolExecutor构造函数自定义参数创建
        java.util.concurrent.ThreadPoolExecutor executor1 = new java.util.concurrent.ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy());

        List<Future<String>> futureList = new ArrayList<>();
        Callable<String> callable = new MyCallable();
        for (int i = 0; i < 10; i++) {
            //提交任务到线程池
            Future<String> future = executor1.submit(callable);
            //将返回值 future 添加到 list，我们可以通过 future 获得 执行 Callable 得到的返回值
            futureList.add(future);
        }
        for (Future<String> fut : futureList) {
            try {
                System.out.println(new Date() + "::" + fut.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        //关闭线程池
        executor1.shutdown();
    }
}
