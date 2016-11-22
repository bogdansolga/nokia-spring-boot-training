package com.oce.springboot.training.d03s03.service;

import com.oce.springboot.training.d03s03.model.Product;
import com.oce.springboot.training.d03s03.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private static final int THROWING_ID = 13;

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Product getProduct(final int id) {
        if (id == THROWING_ID) {
            throw new IllegalArgumentException("There is no product with the ID " + THROWING_ID);
        }

        return productRepository.findOne(id);
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Product> getProducts() {
        final Iterable<Product> allProducts = productRepository.findAll();

        return Optional.ofNullable(allProducts).map(items -> {
            final List<Product> returned = new ArrayList<>();
            items.forEach(returned::add);
            return returned;
        }).orElse(null);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public String saveProduct(final Product product) {
        productRepository.save(product);
        return "OK";
    }
}
