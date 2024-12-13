package ru.job4j.api;

import java.util.List;

public class DropWhile {
    public static void main(String[] args) {
        List.of(1, 2, 3, 4, 1, 2).stream()
                .dropWhile(value -> value < 3)
                .map(value -> "Результат: " + value)
                .forEach(System.out::println);
    }
}