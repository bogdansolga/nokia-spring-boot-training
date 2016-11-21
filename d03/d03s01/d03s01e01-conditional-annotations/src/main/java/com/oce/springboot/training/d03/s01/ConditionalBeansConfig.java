package com.oce.springboot.training.d03.s01;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Spring {@link Configuration} which loads some beans conditionally
 *
 * @author bogdan.solga
 */
@Configuration
public class ConditionalBeansConfig {

    @Bean
    @ConditionalOnClass(DataSource.class)
    public String conditionalOnClass() {
        return "Conditional on the DataSource class";
    }

    @Bean
    @ConditionalOnProperty(name = "matching.property", havingValue = "true")
    public String conditionalOnProperty() {
        return "Conditional on a property";
    }
}
