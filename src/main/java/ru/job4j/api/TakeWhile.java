package ru.job4j.api;

import java.util.List;

public class TakeWhile {
    public static void main(String[] args) {
        List.of(1, 2, 3, 1).stream()
                .takeWhile(value -> value < 3)
                .map(value -> "Результат: " + value)
                .forEach(System.out::println);
    }
}