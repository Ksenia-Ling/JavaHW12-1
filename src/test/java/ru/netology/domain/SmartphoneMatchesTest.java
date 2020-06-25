package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneMatchesTest {

    private Smartphone xiaomi = new Smartphone(4, "Redmi Note 9", 16000, "Xiaomi");
    private Smartphone samsung = new Smartphone(5, "Galaxy A51", 20000, "Samsung");

    @Test
    void SmartphoneMatchesByName() {
        String text = "Redmi Note";
        xiaomi.matches(text);

        assertTrue(xiaomi.matches(text));
    }

    @Test
    void SmartphoneMatchesByProducer() {
        String text = "Samsung";
        samsung.matches(text);

        assertTrue(samsung.matches(text));
    }

    @Test
    void SmartphoneMatchesIfFalse() {
        String text = "A71";
        samsung.matches(text);

        assertFalse(samsung.matches(text));
    }
}
