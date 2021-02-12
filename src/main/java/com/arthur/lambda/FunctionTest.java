package com.arthur.lambda;

import java.util.function.Function;

public class FunctionTest {
    public static void main(String[] args) {
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);
        System.out.println(backToString.apply("123"));     // "123"


        Function<String, Integer> toInteger1 = Integer::valueOf;
        Function<String, Integer> plus = toInteger1.andThen(a -> a+1);
        Function<String, Integer> plus2 = plus.andThen(a -> a+1);
        System.out.println(plus2.apply("123"));     // 125


        Function<Integer, String> toInteger_1 = String::valueOf;
        Function<Integer, Integer> plus_1 = toInteger_1.andThen(Integer::valueOf);
        Function<Integer, Integer> plus_2 = plus_1.andThen(a -> a+1);
        Function<Integer, String> plus_3 = plus_2.andThen(String::valueOf);
        Function<Integer, Integer> plus_4 = plus_3.andThen(Integer::valueOf);
        System.out.println(plus_4.apply(123));     // 125
//      Function的第一个参数是最终的apply调用的时候的输入，而第二个参数是本条Function的返回值。




//      Function的compose就是先搞后面的，再搞前面的，而且里面的Function的泛型只跟最后的apply的返回值和输入类型有关，第一个是最后的输入，第二个是最后的返回值
        Function<String, Integer> toInteger2 = Integer::valueOf; //Function的第一个参数一定是最后调用apply时传入的参数类型
        Function<String, Integer> plus3 = toInteger2.compose(a -> a+1);//Function的第二个参数是最后的最后，需要的返回值
        Function<String, Integer> plus4 = plus3.compose(String::toString);
        Function<String, Integer> plus_44 = plus4.compose(String::toString);
        System.out.println(plus_44.apply("123"));     // 12311


        //      compose就是先搞后面的，再搞前面的
        Function<Integer, Integer> toInteger3 = Integer::valueOf; //Function的第一个参数一定是最后调用apply时传入的参数类型
        Function<Integer, Integer> plus5 = toInteger3.compose(a -> a+1);//Function的第二个参数是最后的最后，需要的返回值
        Function<Integer, Integer> plus6 = plus5.compose(a -> a + 1);
        System.out.println(plus6.apply(123));     // 12311
    }
}

//@FunctionalInterface
//public interface Function<T, R> {
//
//    //将Function对象应用到输入的参数上，然后返回计算结果。
//    R apply(T t);
//    //将两个Function整合，并返回一个能够执行两个Function对象功能的Function对象。
//    default <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
//        Objects.requireNonNull(before);
//        return (V v) -> apply(before.apply(v));
//    }
//    //
//    default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
//        Objects.requireNonNull(after);
//        return (T t) -> after.apply(apply(t));
//    }
//
//    static <T> Function<T, T> identity() {
//        return t -> t;
//    }
//}

