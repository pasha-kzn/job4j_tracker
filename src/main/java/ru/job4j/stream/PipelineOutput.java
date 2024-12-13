package ru.job4j.stream;

import java.util.stream.Stream;

public class PipelineOutput {
    public static void main(String[] args) {
        var stream = Stream.of("one", "one", "two", "three")
                .distinct();
        stream.forEach(System.out::println);
        stream.forEach(System.out::println);
    }
}