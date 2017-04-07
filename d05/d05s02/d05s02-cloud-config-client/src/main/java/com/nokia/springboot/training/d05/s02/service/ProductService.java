package com.nokia.springboot.training.d05.s02.service;

import com.nokia.springboot.training.d05.s02.dto.ProductDTO;
import com.nokia.springboot.training.d05.s02.exceptions.NotFoundException;
import com.nokia.springboot.training.d05.s02.model.Product;
import com.nokia.springboot.training.d05.s02.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;

@Service
public class ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO get(final int id) {
        LOGGER.info("Getting the product with the ID {}...", id);

        final Product product =
                Optional.ofNullable(productRepository.get(id))
                        .orElseThrow(() -> new NotFoundException("There is no product with the id " + id));

        return getProductConverter().apply(product);
    }

    public void removeProduct(final int id) {
        productRepository.remove(id);
    }

    private Function<Product, ProductDTO> getProductConverter() {
        return product -> new ProductDTO(product.getId(), product.getName());
    }
}
