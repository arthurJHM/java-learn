package com.arthur.atmoic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @title: AtomicTest
 * @Author ArthurJi
 * @Date: 2021/3/15 11:10
 * @Version 1.0
 */
public class AtomicTest {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(atomicInteger.incrementAndGet());
    }
}
