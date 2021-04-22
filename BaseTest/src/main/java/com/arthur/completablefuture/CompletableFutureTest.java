package com.arthur.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

/**
 * @title: CompletableFutureTest
 * @Author ArthurJi
 * @Date: 2021/3/15 13:26
 * @Version 1.0
 */
public class CompletableFutureTest {
    public static void main(String[] args) {
        CompletableFuture<Object> objectCompletableFuture = CompletableFuture.supplyAsync(new Supplier<Object>() {
            @Override
            public Object get() {
                return null;
            }
        });
        CompletableFuture.allOf(objectCompletableFuture);
        CompletableFuture.anyOf(objectCompletableFuture);
    }
}
