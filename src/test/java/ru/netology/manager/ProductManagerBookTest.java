package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerBookTest {

    private ProductManager manager = new ProductManager(new ProductRepository());

    private Book callOfCthulhu = new Book(1, "Зов Ктулху", 500, "Говард Лавкрафт");
    private Book theLeftHandOfDarkness = new Book(2, "Левая рука тьмы", 400, "Урсула Ле Гуин");
    private Book aFireUponTheDeep = new Book(3, "Пламя над бездной", 600, "Вернор Виндж");

    @BeforeEach
    public void SetUp() {
        manager.add(callOfCthulhu);
        manager.add(theLeftHandOfDarkness);
        manager.add(aFireUponTheDeep);
    }

    @Test
    void searchBookByFullName() {

        Product[] actual = manager.searchBy("Пламя над бездной");
        Product[] expected = {aFireUponTheDeep};

        assertArrayEquals(expected, actual);

    }

    @Test
    void searchBookByWord() {

        Product[] actual = manager.searchBy("Зов");
        Product[] expected = {callOfCthulhu};

        assertArrayEquals(expected, actual);

    }

    @Test
    void searchBookByAuthor() {

        Product[] actual = manager.searchBy("Урсула Ле Гуин");
        Product[] expected = {theLeftHandOfDarkness};

        assertArrayEquals(expected, actual);

    }

    @Test
    void searchBookIfNotExist() {

        Product[] actual = manager.searchBy("Над пропастью во ржи");
        Product[] expected = {};

        assertArrayEquals(expected, actual);

    }
}
