package com.arthur.foreach;

import java.util.*;

public class ForEachTest {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Larry", "Steve", "James");
        names.forEach(System.out::println);

        Set<String> uniqueNames = new HashSet<>(Arrays.asList("Larry", "Steve", "James"));
        uniqueNames.forEach(System.out::println);

        Queue<String> namesQueue = new ArrayDeque<>(Arrays.asList("Larry", "Steve", "James"));
        namesQueue.forEach(System.out::println);


//        Map没有实现Iterable接口，但它提供了自己的forEach 变体，它接受BiConsumer。
        Map<Integer, String> namesMap = new HashMap<>();
        namesMap.put(1, "Larry");
        namesMap.put(2, "Steve");
        namesMap.put(3, "James");
        namesMap.forEach((key, value) -> System.out.println(key + " " + value));

        namesMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));



    }
}
