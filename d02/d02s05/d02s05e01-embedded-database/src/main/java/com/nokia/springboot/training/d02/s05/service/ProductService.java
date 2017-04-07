package com.nokia.springboot.training.d02.s05.service;

import com.nokia.springboot.training.d02.s05.repository.ProductRepository;
import com.nokia.springboot.training.d02.s05.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Service
public class ProductService {

    private final JdbcTemplate jdbcTemplate;
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(final JdbcTemplate jdbcTemplate, final ProductRepository productRepository) {
        this.jdbcTemplate = jdbcTemplate; this.productRepository = productRepository;
    }

    @PostConstruct
    public void init() {
        final Product product = new Product();
        product.setName("A default product");
        product.setPrice(25);
        create(product);
    }

    public void searchForProducts() {
        //TODO insert complex logic here

        jdbcTemplate.execute("SELECT * FROM product p WHERE p.name = ?");
    }

    @Transactional(
            readOnly = false,
            propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_COMMITTED,
            rollbackFor = IllegalArgumentException.class
    )
    public void create(final Product product) {
        productRepository.save(product);
    }

    @Transactional(
            readOnly = true,
            propagation = Propagation.SUPPORTS,
            isolation = Isolation.READ_COMMITTED,
            rollbackFor = {IllegalArgumentException.class, IllegalAccessException.class}
    )
    public Product get(final int id) {
        return productRepository.findOne(id);
    }

    @Transactional(
            readOnly = true,
            propagation = Propagation.SUPPORTS
    )
    public Iterable<Product> getAll() {
        return productRepository.findAll();
    }

    public void update(final int id, final Product product) {
        final Product existingProduct = productRepository.findOne(id);

        existingProduct.setName(product.getName());

        productRepository.save(product);
    }

    public void delete(final int id) {
        productRepository.delete(id);
    }
}
