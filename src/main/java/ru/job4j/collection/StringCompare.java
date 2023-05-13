package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        for (int i = 0; i < Integer.min(left.length(), right.length()); i++) {
            int cmp = Character.compare(left.charAt(i), right.charAt(i));
            if (cmp != 0) {
                return cmp;
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}