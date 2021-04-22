package com.arthur.lambda;

@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);
}

