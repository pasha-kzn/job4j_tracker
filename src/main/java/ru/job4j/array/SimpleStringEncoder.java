package ru.job4j.array;

public class SimpleStringEncoder {
    public static String encode(String input) {
        int counter = 1;
        char symbol = input.charAt(0);
        String result = "" + symbol;
        for (int i = 1; i < input.length(); i++) {
            char previosSymbol = input.charAt(i - 1);
            char currentSymbol = input.charAt(i);
            if (previosSymbol != currentSymbol) {
                if (counter == 1) {
                    result = result + currentSymbol;
                } else {
                    result = result + counter + currentSymbol;
                }
                counter = 0;
            }
            counter++;
            if (i == input.length() - 1 && counter != 1) {
                result += counter;
            }
        }
        return result;
    }
}