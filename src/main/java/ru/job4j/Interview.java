package ru.job4j;

import java.util.*;
import java.util.stream.*;

public class Interview {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 4, 2, 1, 3, 4, 5, 6, 7, 9, 9, 8, 2, 3, 4, 5, 6, 1);
        var mapa4 = countNumbersFour(numbers);
    }

    public static Map<Integer, Long> countNumbersFour(List<Integer> number) {
        return number.stream().collect(Collectors.toMap(element -> element,
                element -> 1L,
                (existing, replacement) -> existing + 1));
    }
}
