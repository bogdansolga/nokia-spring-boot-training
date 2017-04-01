package com.nokia.springboot.training.d01.s03.config;

import com.nokia.springboot.training.d01.s03.repository.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * A simple Spring configuration, which exposes a single aliased bean
 *
 * @author bogdan.solga
 */
@Configuration
public class BeanAliasingConfig {

    @Bean(name = {"productRepository", "repository", "prodRepo"})
    public ProductRepository productRepository() {
        return new ProductRepository();
    }
}
