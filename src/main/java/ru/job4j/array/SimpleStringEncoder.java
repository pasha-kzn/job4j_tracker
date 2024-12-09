package ru.job4j.array;

public class SimpleStringEncoder {
    public static String encode(String input) {
        int counter = 1;
        char symbol = input.charAt(0);
        String result = "" + symbol;
        for (int i = 1; i < input.length(); i++) {;
            if (input.charAt(i - 1) != input.charAt(i)) {
                if (counter == 1) {
                    result = result + input.charAt(i);
                } else {
                    result = result + counter + input.charAt(i);
                }
                counter = 0;
            }
            counter++;
        }
        if (counter != 1) {
            result += counter;
        }
        return result;
    }
}