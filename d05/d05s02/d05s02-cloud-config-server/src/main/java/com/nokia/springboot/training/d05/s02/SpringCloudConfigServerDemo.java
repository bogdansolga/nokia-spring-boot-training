package com.nokia.springboot.training.d05.s02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * A small Spring Boot demo for demoing the usage of a Spring Cloud config server
 *
 * @author bogdan.solga
 */
@SpringBootApplication
@EnableConfigServer
public class SpringCloudConfigServerDemo {

    public static void main(String[] args) {
        // There is a "native" profile in the Config Server that doesn't use Git,
        // but loads the config files from the file system
        System.setProperty("spring.profiles.active", "native");

        SpringApplication.run(SpringCloudConfigServerDemo.class, args);
    }
}
