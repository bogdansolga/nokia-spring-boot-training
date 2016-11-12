package com.oce.springboot.training.d01.s02.service;

import com.oce.springboot.training.d01.s02.repository.ProductRepository;

/**
 * A simple product service, which uses a {@link ProductRepository} as a collaborator
 *
 * @author bogdan.solga
 */
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void displayProducts() {
        productRepository.displayProducts();
    }
}
