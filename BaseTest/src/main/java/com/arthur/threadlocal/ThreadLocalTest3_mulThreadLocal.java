package com.arthur.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadLocalTest3_mulThreadLocal {
    public static void main(String[] args) {
        System.out.println("================================ThreadLocal==========================================");
        ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd HHmm"));
        System.out.println(formatter.get().format(new Date()));
        ThreadLocal<SimpleDateFormat> formatter_2 = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd HHmm"));
        System.out.println(formatter_2.get().format(new Date()));
    }
}
