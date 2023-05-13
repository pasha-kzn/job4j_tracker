package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int cmpLength = Integer.compare(left.length(), right.length());
        int cmp = 0;
        for (int i = 0; i < Integer.min(left.length(), right.length()); i++) {
            cmp = Character.compare(left.charAt(i), right.charAt(i));
            if (cmp != 0) {
                return cmp;
            }
        }
        return cmpLength != 0 ? cmpLength : cmp;
    }
}