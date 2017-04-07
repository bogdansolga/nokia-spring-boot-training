package com.nokia.springboot.training.d05.s02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * A small Spring Boot demo for demoing the usage of a Spring Cloud config client
 *
 * @author bogdan.solga
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudConfigClientDemo {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigClientDemo.class, args);
    }
}
