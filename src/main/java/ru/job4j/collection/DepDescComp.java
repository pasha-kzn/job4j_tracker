package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare (String left, String right) {
        String[] leftArray = left.split("/");
        String[] rightArray = right.split("/");
        int length = Math.min(leftArray.length, rightArray.length);
        for (int i = 0; i < length; i++) {
            if (leftArray[0].compareTo(rightArray[0]) != 0) {
                return right.compareTo(left);
            }
            if (leftArray[i].compareTo(rightArray[i]) != 0) {
                return left.compareTo(right);
            }
        }
        return left.compareTo(right);
    }
}
