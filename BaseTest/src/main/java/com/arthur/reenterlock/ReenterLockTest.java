package com.arthur.reenterlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @title: ReenterLockTest
 * @Author ArthurJi
 * @Date: 2021/3/21 20:19
 * @Version 1.0
 */
public class ReenterLockTest {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.unlock();

    }
}
