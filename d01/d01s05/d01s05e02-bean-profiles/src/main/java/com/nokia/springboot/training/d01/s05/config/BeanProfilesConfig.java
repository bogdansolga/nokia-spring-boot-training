package com.nokia.springboot.training.d01.s05.config;

import com.nokia.springboot.training.d01.s05.service.ProductService;
import com.nokia.springboot.training.d01.s05.repository.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * A Spring configuration which wires several {@link Bean}s according to the used {@link Profile}
 *
 * @author bogdan.solga
 */
@Configuration
public class BeanProfilesConfig {

    @Bean
    @Profile(Profiles.DEV)
    public ProductService devProductService() {
        return new ProductService(devProductRepository());
    }

    @Bean
    @Profile(Profiles.PROD)
    public ProductService prodProductService() {
        return new ProductService(prodProductRepository());
    }

    @Bean
    public ProductRepository devProductRepository() {
        return new ProductRepository("H2");
    }

    @Bean
    public ProductRepository prodProductRepository() {
        return new ProductRepository("PostgresQL");
    }
}
