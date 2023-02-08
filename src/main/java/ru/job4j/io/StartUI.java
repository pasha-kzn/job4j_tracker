package ru.job4j.io;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) throws InterruptedException {
        Item item = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println(item.getCreated().format(formatter));
        System.out.println(item);
    }
}
