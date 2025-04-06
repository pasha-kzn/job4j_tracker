package ru.job4j.calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class FitTest {
    @Test
    public void manWeightShouldCalculateCorrectly() {
        double result = Fit.manWeight((short) 187);
        assertThat(result).isEqualTo(100.05);
    }

    @Test
    void manWeightShouldCalculateCorrectlyForNormalHeight() {
        double result = Fit.manWeight((short) 187);
        assertThat(result).isEqualTo(100.05, withPrecision(0.01d));
    }

    @Test
    void manWeightShouldCalculateZeroForBaseHeight() {
        double result = Fit.manWeight((short) 100);
        assertThat(result).isEqualTo(0.0, withPrecision(0.01d));
    }

    @Test
    void womanWeightShouldCalculateCorrectlyForNormalHeight() {
        double result = Fit.womanWeight((short) 170);
        assertThat(result).isEqualTo(69.0, withPrecision(0.01d));
    }

    @Test
    void womanWeightShouldCalculateZeroForBaseHeight() {
        double result = Fit.womanWeight((short) 110);
        assertThat(result).isEqualTo(0.0, withPrecision(0.01d));
    }

    @Test
    void womanWeightShouldHandleMaxShortValue() {
        double result = Fit.womanWeight(Short.MAX_VALUE);
        assertThat(result > 0).isTrue();
    }
}