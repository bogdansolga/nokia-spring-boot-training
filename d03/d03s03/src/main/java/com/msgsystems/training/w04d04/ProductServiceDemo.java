package com.msgsystems.training.w04d04;

import com.msgsystems.training.w04d04.config.ProductServiceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceDemo {

    public static void main(String[] args) {
        new SpringApplication(ProductServiceConfig.class).run(args);
    }
}
