package com.nokia.springboot.training.d01.s04.model;

import java.io.Serializable;

public class Product implements Serializable {

    private final int id;
    private final String name;

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
