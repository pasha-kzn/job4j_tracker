package ru.job4j.calculator;

public class Fit {
    private static final double BASE_MAN = 100;
    private static final double BASE_WOMAN = 110;
    private static final double MULTIPLIER = 1.15;

    public static double calculateIdealWeight(short height, double base) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be positive");
        }
        return (height - base) * MULTIPLIER;
    }

    public static double manWeight(short heightMan) {
        return calculateIdealWeight(heightMan, BASE_MAN);
    }

    public static double womanWeight(short heightWoman) {
        return calculateIdealWeight(heightWoman, BASE_WOMAN);
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: Fit <manHeight> <womanHeight>");
            return;
        }
        short heightMan = Short.parseShort(args[0]);
        short heightWoman = Short.parseShort(args[1]);

        double man = Fit.manWeight(heightMan);
        System.out.printf("Man %d cm: ideal weight = %.2f kg%n", heightMan, man);

        double woman = Fit.womanWeight(heightWoman);
        System.out.printf("Woman %d cm: ideal weight = %.2f kg%n", heightWoman, woman);
    }
}
