package com.msgsystems.training.w04d04.service;

import com.msgsystems.training.w04d04.model.Product;
import com.msgsystems.training.w04d04.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private static final int THROWING_ID = 13;

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProduct(final int id) {
        if (id == THROWING_ID) {
            throw new IllegalArgumentException("There is no product with the ID " + THROWING_ID);
        }

        return productRepository.get(id);
    }

    public List<Product> getProducts() {
        return productRepository.getProducts();
    }

    public String saveProduct(final Product product) {
        productRepository.saveProduct(product);
        return "OK";
    }
}
