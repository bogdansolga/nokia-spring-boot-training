package com.nokia.springboot.training.d04.s01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * A Spring Boot class which demos the async processing on the presentation layer
 *
 * @author bogdan.solga
 */
@SpringBootApplication
public class AsynProcessingPresentationLayerDemo {

    public static void main(String[] args) {
        new SpringApplication(AsynProcessingPresentationLayerDemo.class).run(args);
    }
}
