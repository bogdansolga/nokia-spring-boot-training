package com.nokia.springboot.training.d05.s02.repository;

import com.nokia.springboot.training.d05.s02.model.Product;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Repository
public class ProductRepository {

    private static final Random RANDOM = new Random(100);

    // an in-memory list of products
    private List<Product> products = new ArrayList<>(10);

    @PostConstruct
    public void init() {
        IntStream.range(0, 10)
                 .forEach(entry -> products.add(buildRandomProduct()));
    }

    public Product get(int id) {
        return id < products.size() ? products.get(id) : null;
    }

    public void remove(final int id) {
        products.remove(id);
    }

    private Product buildRandomProduct() {
        final Product product = new Product();

        product.setId(RANDOM.nextInt(100));
        product.setName("The product with the ID " + product.getId());

        return product;
    }
}
