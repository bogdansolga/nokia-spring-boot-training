package com.oce.springboot.training.d01.s02.config;

import com.oce.springboot.training.d01.s02.repository.ProductRepository;
import com.oce.springboot.training.d01.s02.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * A simple Spring configuration, which wires two simple {@link Bean}s
 *
 * @author bogdan.solga
 */
@Configuration
public class DomainConfig {

    @Bean
    public ProductRepository productRepository() {
        return new ProductRepository();
    }

    @Bean
    public ProductService productService() {
        return new ProductService(productRepository());
    }
}
