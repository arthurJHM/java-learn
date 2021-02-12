package com.arthur.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadLocalTest2 {
    public static void main(String[] args) {
        System.out.println("================================ThreadLocal==========================================");
        ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd HHmm"));
        System.out.println(formatter.get().format(new Date()));
    }
}
