package com.arthur.threadpoolexecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @title: ExecutorsTest
 * @Author ArthurJi
 * @Date: 2021/3/14 21:45
 * @Version 1.0
 */
public class ExecutorsTest {
    public static void main(String[] args) {
//        这俩运行创建的进程为MAX_VALUE
        Executors.newScheduledThreadPool(1);
        Executors.newCachedThreadPool();

//        这俩请求队列为Integer.MAX_VALUE  会OOM
        Executors.newFixedThreadPool(1);
        Executors.newSingleThreadExecutor();

        new ThreadPoolExecutor(5, 10, 1, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10), new ThreadPoolExecutor.AbortPolicy());

    }
}
