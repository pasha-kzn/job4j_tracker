package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchFolder {
    public static List<Folder> filter(List<Folder> list, Predicate<Folder> predicate) {
        List<Folder> result = new ArrayList<>();
        for (Folder folder : list) {
            if (predicate.test(folder)) {
                result.add(folder);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Folder> result = new ArrayList<>();
        result.add(new Folder("One", 1000));
        result.add(new Folder("Two", 2000));
        result.forEach(f -> filter(result, string -> f.getName().contains("One")));
    }
}