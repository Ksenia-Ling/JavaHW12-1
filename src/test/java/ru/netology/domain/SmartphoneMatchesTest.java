package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneMatchesTest {

    private Smartphone xiaomi = new Smartphone(4, "Redmi Note 9", 16000, "Xiaomi");
    private Smartphone samsung = new Smartphone(5, "Galaxy A51", 20000, "Samsung");

    @Test
    void SmartphoneMatchesByName() {
        String text = "Redmi Note";

        assertTrue(xiaomi.matches(text));
    }

    @Test
    void SmartphoneMatchesByProducer() {
        String text = "Samsung";

        assertTrue(samsung.matches(text));
    }

    @Test
    void SmartphoneMatchesIfFalse() {
        String text = "A71";

        assertFalse(samsung.matches(text));
    }
}
