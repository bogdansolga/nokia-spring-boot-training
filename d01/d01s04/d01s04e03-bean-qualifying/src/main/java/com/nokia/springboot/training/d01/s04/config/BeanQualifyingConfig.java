package com.nokia.springboot.training.d01.s04.config;

import com.nokia.springboot.training.d01.s04.repository.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * A simple Spring configuration, which exposes two {@link ProductRepository} {@link Bean}s
 *
 * @author bogdan.solga
 */
@Configuration
@ComponentScan(basePackages = "com.nokia.springboot.training")
public class BeanQualifyingConfig {

    @Bean
    public ProductRepository mySQLProductRepository() {
        return new ProductRepository("MySQL");
    }

    @Bean
    public ProductRepository oracleProductRepository() {
        return new ProductRepository("Oracle");
    }
}
