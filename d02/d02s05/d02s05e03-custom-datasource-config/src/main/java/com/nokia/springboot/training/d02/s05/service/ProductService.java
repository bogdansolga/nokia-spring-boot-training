package com.nokia.springboot.training.d02.s05.service;

import com.nokia.springboot.training.d02.s05.repository.ProductRepository;
import com.nokia.springboot.training.d02.s05.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void create(final Product product) {
        productRepository.save(product);
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Product get(final int id) {
        return productRepository.findOne(id);
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Iterable<Product> getAll() {
        return productRepository.findAll();
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void update(final int id, final Product product) {
        final Product existingProduct = productRepository.findOne(id);

        existingProduct.setName(product.getName());

        productRepository.save(product);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void delete(final int id) {
        productRepository.delete(id);
    }
}
