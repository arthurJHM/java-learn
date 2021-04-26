package com.arthur.stream;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @title: StreamTest2
 * @Author ArthurJi
 * @Date: 2021/4/26 12:43
 * @Version 1.0
 */
public class StreamTest2 {
    public static void main(String[] args) {
        Stream<String> generate = Stream.generate(() -> "Echo");
        show(generate);

        show(Stream.generate(Math::random));

        show(Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE)));
/*        BigInteger limmit = new BigInteger("15"); //这玩意跟书上讲的不一样 好像没有噶
        show(Stream.iterate(BigInteger.ZERO, n -> n.compareTo(limmit) < 0, n -> n.add(BigInteger.ONE)));*/

        Stream.iterate(1.0, p -> p * 2)
                .peek(e -> System.out.print(e))
                .limit(20)
                .toArray();
    }

    private static <T> void show(Stream<T> stream) {
        List<T> collect = stream.limit(10).collect(Collectors.toList());
        for (T s : collect) {
            System.out.print(s);
            System.out.print(" ");
        }
        System.out.println();
    }
}
