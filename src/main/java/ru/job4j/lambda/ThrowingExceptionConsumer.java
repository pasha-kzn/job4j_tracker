package ru.job4j.lambda;

import java.util.function.*;

@FunctionalInterface
public interface ThrowingExceptionConsumer<T, E extends Exception> {
    void accept(T t) throws E;

    static <T> Consumer<T> throwingExceptionConsumerWrapper(
            ThrowingExceptionConsumer<T, Exception> throwingExceptionConsumer) {
        return x -> {
            try {
                throwingExceptionConsumer.accept(x);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}


