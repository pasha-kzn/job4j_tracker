package ru.job4j.my;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DoNotSendToGit {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 3, 4, 1, 2);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

        Integer first = 1;
        Integer second = 2;
        Integer first1 = 1;
        int rsl1 = first.compareTo(second);
        System.out.println(rsl1);
        int rsl2 = second.compareTo(first);
        System.out.println(rsl2);
        int rsl3 = first1.compareTo(first);
        System.out.println(rsl3);

        String petr = "Petr";
        String ivan = "Ivan";
        int rslStr = petr.compareTo(ivan);
        System.out.println(rslStr);

        List<Integer> list1 = Arrays.asList(5, 3, 4, 1, 2);
        System.out.println(list1);
        Collections.sort(list1);
        System.out.println(list1);
        Collections.sort(list1, Collections.reverseOrder());
        System.out.println(list1);
    }
}
