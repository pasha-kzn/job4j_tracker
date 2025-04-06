package ru.job4j.calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class FitTest {
    @Test
    public void manWeight_ShouldCalculateCorrectly() {
        double result = Fit.manWeight((short) 187);
        assertThat(result).isEqualTo(100.05);
    }

    @Test
    void manWeight_ShouldCalculateCorrectlyForNormalHeight() {
        double result = Fit.manWeight((short) 187);
        assertThat(result).isEqualTo(100.05, withPrecision(0.01d));
    }

    @Test
    void manWeight_ShouldCalculateZeroForBaseHeight() {
        double result = Fit.manWeight((short) 100);
        assertThat(result).isEqualTo(0.0, withPrecision(0.01d));
    }

    @Test
    void womanWeight_ShouldCalculateCorrectlyForNormalHeight() {
        double result = Fit.womanWeight((short) 170);
        assertThat(result).isEqualTo(69.0, withPrecision(0.01d));
    }

    @Test
    void womanWeight_ShouldCalculateZeroForBaseHeight() {
        double result = Fit.womanWeight((short) 110);
        assertThat(result).isEqualTo(0.0, withPrecision(0.01d));
    }

    @Test
    void womanWeight_ShouldHandleMaxShortValue() {
        double result = Fit.womanWeight(Short.MAX_VALUE);
        assertThat(result > 0).isTrue();
    }
}