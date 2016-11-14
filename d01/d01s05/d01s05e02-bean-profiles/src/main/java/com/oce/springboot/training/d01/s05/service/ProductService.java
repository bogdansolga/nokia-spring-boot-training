package com.oce.springboot.training.d01.s05.service;

import com.oce.springboot.training.d01.s05.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * A simple product {@link Service}, which uses the {@link ProductRepository} as an {@link Autowired} collaborator
 *
 * @author bogdan.solga
 */
@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void displayProducts() {
        productRepository.displayProducts();
    }
}
