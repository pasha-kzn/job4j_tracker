package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
    /*Метод public Item[] findAll() возвращает копию массива items без null элементов (без пустых ячеек).*/
    public Item[] findAll() {
        Item[] rsl = new Item[items.length];
        int size = 0;
        for (int i = 0; i < items.length; i++) {
            String name = items[i].getName();
            if (name != null) {
                rsl[i] = new Item(name);
                size++;
            }
            break;
        }
        rsl = Arrays.copyOf(rsl, size);
        return rsl;
    }
    /*Метод public Item[] findByName(String key) проверяет в цикле все элементы массива items, сравнивая name (используя метод getName класса Item)
     с аргументом метода String key. Элементы, у которых совпадает name, копирует в результирующий массив и возвращает его.
     Алгоритм этого метода аналогичен методу findAll.*/
    public Item[] findByName(String key) {
        Item[] rsl = new Item[items.length];
        int size = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && key.equals(items[i].getName())) {
                rsl[i] = new Item(key);
                size++;
            }
        }
        rsl = Arrays.copyOf(rsl, size);
        return rsl;
    }
}