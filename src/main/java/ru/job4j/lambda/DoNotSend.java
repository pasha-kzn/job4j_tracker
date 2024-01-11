package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class DoNotSend {
    public static void main(String[] args) {
        String[] names = {
                "Xyz",
                "Petr",
                "Ivan"
        };
        Comparator<String> lengthComparator = (left, right) -> {
            System.out.println("execute comparator " + left + " + " + right);
            return Integer.compare(left.length(), right.length());
        };
        Arrays.sort(names, lengthComparator);
    }
}
