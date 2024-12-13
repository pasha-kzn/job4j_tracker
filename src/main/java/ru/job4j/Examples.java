package ru.job4j;

import ru.job4j.tracker.*;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Examples {
    public static void main(String[] args) {
        System.out.println(
                List.of(1, 3, 2, 2, 6
                ).stream().collect(
                        Collectors.toMap(
                                element -> element,
                                element -> element * element,
                                (existing, replacement) -> existing * 10
                        ))
        );
    }
}
