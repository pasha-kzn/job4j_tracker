package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("pavelmatweeff@yandex.ru", "Мatveev Pavel");
        map.put("ilyamatweev@yandex.ru", "Мatveev Ilya P.");
        map.put("polinamatweeva@yandex.ru", "Мatveeva Polina P.");
        map.put("pavelmatweeff@yandex.ru", "Мatveev Pavel A.");
        for (String key : map.keySet()) {
            System.out.println(map.get(key));
        }
    }
}
