package com.oce.springboot.training.d01.s03.config;

import com.oce.springboot.training.d01.s03.repository.ProductRepository;
import com.oce.springboot.training.d01.s03.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

/**
 * A simple Spring configuration, which wires two simple {@link Bean}s and exposes them as {@link Lazy} and {@link Primary} beans
 *
 * @author bogdan.solga
 */
@Configuration
public class BeanAttributesConfig {

    @Lazy
    @Bean
    public ProductRepository productRepository() {
        System.out.println("Initializing the 'productRepository' bean");
        return new ProductRepository();
    }

    @Primary
    @Bean
    public ProductService primaryProductService() {
        return new ProductService(productRepository(), "primaryProductService");
    }

    @Bean
    public ProductService productService() {
        return new ProductService(productRepository(), "productService");
    }
}
