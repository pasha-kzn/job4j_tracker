package ru.job4j.function;

import java.util.function.Predicate;

public class StrategyUsage {
    public boolean empty(String string) {
        return check(str -> str.isEmpty(), string);
    }

    public boolean startWith(String string, String prefix) {
        return check(str -> str.startsWith(prefix), string);
    }

    public boolean contains(String string, String key) {
        return check(str -> str.contains(key), string);
    }

    public boolean check(Predicate<String> predicate, String string) {
        return predicate.test(string);
    }
}