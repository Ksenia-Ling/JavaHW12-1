package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerSmartphoneTest {

    private ProductManager manager = new ProductManager(new ProductRepository());

    private Smartphone xiaomi = new Smartphone(4, "Redmi Note 9", 16000, "Xiaomi");
    private Smartphone samsung = new Smartphone(5, "Galaxy A51", 20000, "Samsung");
    private Smartphone iPhone = new Smartphone(6, "iPhone 11", 60000, "Apple");

    @BeforeEach
    public void SetUp() {
        manager.add(xiaomi);
        manager.add(samsung);
        manager.add(iPhone);
    }

    @Test
    void searchPhoneByName() {

        Product[] actual = manager.searchBy("iPhone 11");
        Product[] expected = {iPhone};

        assertArrayEquals(expected, actual);

    }

    @Test
    void searchPhoneByProducer() {

        Product[] actual = manager.searchBy("Xiaomi");
        Product[] expected = {xiaomi};

        assertArrayEquals(expected, actual);

    }

    @Test
    void searchPhoneByPartOfWord() {

        Product[] actual = manager.searchBy("Sam");
        Product[] expected = {samsung};

        assertArrayEquals(expected, actual);

    }

    @Test
    void searchPhoneIfRemoved() {
        manager.removeById(6);

        Product[] actual = manager.searchBy("iPhone");
        Product[] expected = {};

        assertArrayEquals(expected,actual);
    }

    @Test
    void searchPhoneIfNotExist() {

        Product[] actual = manager.searchBy("Huawei");
        Product[] expected = {};

        assertArrayEquals(expected, actual);

    }
}