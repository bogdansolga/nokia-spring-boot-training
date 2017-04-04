package com.nokia.springboot.training.d01.s04.config;

import com.nokia.external.service.ExternalService;
import com.nokia.springboot.training.d01.s04.repository.ProductRepository;
import com.nokia.springboot.training.d01.s04.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * A simple Spring configuration, which wires the beans automatically via {@link ComponentScan}ing
 *
 * @author bogdan.solga
 */
@Configuration
// implicit bean definition / scanning
@ComponentScan(basePackages = "com.nokia.springboot.training.d01.s04")
public class ComponentModelConfig {

    // explicit bean definition
    @Bean
    public ExternalService externalService () {
        return new ExternalService();
    }

    @Bean
    public ProductService productService() {
        return new ProductService(productRepository());
    }

    @Bean
    public ProductRepository productRepository() {
        return new ProductRepository();
    }
}
