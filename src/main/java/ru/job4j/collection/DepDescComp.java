package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftArray = left.split("/");
        String[] rightArray = right.split("/");
        int result = rightArray[0].compareTo(leftArray[0]);
        return result != 0 ? result : left.compareTo(right);
    }
}
