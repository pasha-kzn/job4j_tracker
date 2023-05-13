package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        left = left.split("[^0-9]+")[0];
        right = right.split("[^0-9]+")[0];
        return Integer.compare(Integer.parseInt(left), Integer.parseInt(right));
    }
}