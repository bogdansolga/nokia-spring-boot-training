package com.nokia.springboot.training.d01.s05.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * A Spring configuration which loads a properties file
 *
 * @author bogdan.solga
 */
@Configuration
@ComponentScan(basePackages = "com.nokia.springboot.training.d01.s05")
@PropertySource(value = "application.properties")
@PropertySource(value = "file:${user.home}/an-external-file.properties")
public class PropertiesLoadingConfig {
}
