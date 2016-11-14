package com.oce.springboot.training.d01.s05.repository;

import org.springframework.stereotype.Repository;

/**
 * A simple product repository
 *
 * @author bogdan.solga
 */
@Repository
public class ProductRepository {

    private final String databaseType;

    public ProductRepository(final String databaseType) {
        this.databaseType = databaseType;
    }

    public void displayProducts() {
        System.out.println("Displaying all the products from the '" + databaseType + "' database...");
    }
}
