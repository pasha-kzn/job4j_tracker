package ru.job4j.lambda;

public class Model {
    private String name;
    private int age;

    Model() {
    }

    Model(String str) {
        name = str;
    }

    Model(String str, int age) {
        name = str;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }
}