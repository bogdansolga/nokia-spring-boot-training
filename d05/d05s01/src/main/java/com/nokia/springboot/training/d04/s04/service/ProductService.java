package com.nokia.springboot.training.d04.s04.service;

import com.nokia.springboot.training.d04.s04.dto.ProductDTO;
import com.nokia.springboot.training.d04.s04.exceptions.NotFoundException;
import com.nokia.springboot.training.d04.s04.model.Product;
import com.nokia.springboot.training.d04.s04.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;

import static com.nokia.springboot.training.d04.s04.config.CacheNames.PRODUCTS;

@Service
public class ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Cacheable(
            cacheNames = PRODUCTS,
            key = "#id"
    )
    public ProductDTO get(final int id) {
        LOGGER.info("Getting the product with the ID {}...", id);

        final Product product =
                Optional.ofNullable(productRepository.get(id))
                        .orElseThrow(() -> new NotFoundException("There is no product with the id " + id));

        return getProductConverter().apply(product);
    }

    @CacheEvict(
            cacheNames = PRODUCTS,
            key = "#id"
    )
    public void removeProduct(final int id) {
        productRepository.remove(id);
    }

    private Function<Product, ProductDTO> getProductConverter() {
        return product -> new ProductDTO(product.getId(), product.getName());
    }
}
