package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class BookMatchesTest {

    private Book callOfCthulhu = new Book(1, "Зов Ктулху", 500, "Говард Лавкрафт");
    private Book theLeftHandOfDarkness = new Book(2, "Левая рука тьмы", 400, "Урсула Ле Гуин");

    @Test
    void bookMatchesByName() {
        String text = "рука";
        theLeftHandOfDarkness.matches(text);

        assertTrue(theLeftHandOfDarkness.matches(text));

    }

    @Test
    void bookMatchesByAuthor() {
        String text = "Урсула";
        theLeftHandOfDarkness.matches(text);

        assertTrue(theLeftHandOfDarkness.matches(text));
    }

    @Test
    void BookMatchesIfFalse() {
        String text = "Джоан Роулинг";
        callOfCthulhu.matches(text);

        assertFalse(callOfCthulhu.matches(text));
    }
}