package ru.netology.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)

public class Smartphone extends Product {
    private String producer;

    public Smartphone(int id, String name, int price, String producer) {
        super(id,name,price);
        this.producer = producer;
    }

    @Override
    public boolean matches(String search) {
        return super.matches(search) || producer.contains(search);
    }
}
