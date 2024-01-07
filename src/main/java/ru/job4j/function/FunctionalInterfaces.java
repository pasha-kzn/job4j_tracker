package ru.job4j.function;

import java.util.*;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        List<String> list = List.of("one", "two", "three", "four", "five", "six", "seven");
        BiConsumer<Integer, String> biConsumer = (key, value) -> map.put(key, value);
        for (int i = 0; i < list.size(); i++) {
            biConsumer.accept(i + 1, list.get(i));
        }
        BiPredicate<Integer, String> biPredicate = (number, string) -> (number % 2 == 0 || string.length() == 4);
        for (Integer key : map.keySet()) {
            if (biPredicate.test(key, map.get(key))) {
                System.out.println("key: " + key + " value: " + map.get(key));
            }
        }
        Supplier<List<String>> supplier = () -> new ArrayList<>(map.values());
        List<String> strings = new ArrayList<>(supplier.get());
        Consumer<String> consumer = (string) -> System.out.println(string);
        Function<String, String> function = string -> string.toUpperCase();
        for (String string : strings) {
            consumer.accept(function.apply(string));
        }
    }
}