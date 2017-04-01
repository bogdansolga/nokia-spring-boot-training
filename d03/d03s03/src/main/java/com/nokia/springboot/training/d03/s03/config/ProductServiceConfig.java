package com.nokia.springboot.training.d03.s03.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.nokia.springboot.training.d03.s03.repository")
public class ProductServiceConfig {
}
