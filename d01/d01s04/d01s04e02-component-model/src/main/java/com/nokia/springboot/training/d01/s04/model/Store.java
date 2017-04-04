package com.nokia.springboot.training.d01.s04.model;

import java.io.Serializable;
import java.util.Set;

public class Store implements Serializable {

    private final int id;
    private final String name;
    private final Set<Product> products;

    public Store(int id, String name, Set<Product> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Product> getProducts() {
        return products;
    }
}
