package ru.job4j.stream;

import java.util.stream.*;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Value.values())
                        .map(value1 -> suit + " " + value1))
                .forEach(System.out::println);
    }
}
