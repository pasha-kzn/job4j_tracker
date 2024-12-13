package ru.job4j.stream;

import java.util.*;
import java.util.stream.*;

public class MinExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4, 5, 1, 3, 2);
        Optional<Integer> minEl = list.stream()
                .min(Comparator.naturalOrder());
        System.out.println(minEl.get());
        System.out.println("");
        OptionalInt min = IntStream
                .rangeClosed(13, 15)
                .min();
        System.out.println(min.getAsInt());

    }
}