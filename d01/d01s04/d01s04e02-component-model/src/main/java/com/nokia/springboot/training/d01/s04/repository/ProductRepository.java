package com.nokia.springboot.training.d01.s04.repository;

import org.springframework.stereotype.Repository;

/**
 * A simple product repository
 *
 * @author bogdan.solga
 */
@Repository
public class ProductRepository {

    public void displayProducts() {
        // would connect to a real / embedded dataSource
        System.out.println("Displaying all the products");
    }
}
