package com.arthur.deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @title: FindDeadLock
 * @Author ArthurJi
 * @Date: 2021/1/10 11:12
 * @Version 1.0
 */
public class FindDeadLock extends Thread {
    private String first;
    private String second;

    public FindDeadLock(String name, String first, String second) {
        super(name);
        this.first = first;
        this.second = second;
    }

    public void run() {
        synchronized (first) {
            System.out.println(this.getName() + " obtain " + first);
            try {
                Thread.sleep(1000);
                synchronized (second) {
                    System.out.println(this.getName() + " obtain " + second);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        Runnable deadLockCheck = new Runnable() {
            @Override
            public void run() {
                long[] deadlockedThreads = threadMXBean.findDeadlockedThreads();
                if(deadlockedThreads != null) {
                    ThreadInfo[] threadInfo = threadMXBean.getThreadInfo(deadlockedThreads);
                    System.out.println("find lockThread");
                    for (ThreadInfo info : threadInfo) {
                        System.out.println(info);
                    }
                }
            }
        };

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(deadLockCheck,5L, 5L, TimeUnit.SECONDS);


        String lockA = "A";
        String lockB = "B";
        DeadLockSample t1 = new DeadLockSample("Thread1", lockA, lockB);
        DeadLockSample t2 = new DeadLockSample("Thread2", lockB, lockA);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
