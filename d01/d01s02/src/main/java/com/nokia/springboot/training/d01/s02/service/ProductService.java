package com.nokia.springboot.training.d01.s02.service;

import com.nokia.springboot.training.d01.s02.repository.ProductRepository;

import java.util.Optional;

/**
 * A simple product service, which uses a {@link ProductRepository} as a collaborator
 *
 * @author bogdan.solga
 */
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void displayProducts() {
        Optional.ofNullable(productRepository).ifPresent(ProductRepository::displayProducts);
    }
}
