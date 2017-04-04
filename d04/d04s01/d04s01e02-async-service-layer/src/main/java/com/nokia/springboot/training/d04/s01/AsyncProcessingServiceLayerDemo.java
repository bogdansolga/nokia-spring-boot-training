package com.nokia.springboot.training.d04.s01;

import com.nokia.springboot.training.d04.s01.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * A Spring Boot class which demos the async processing on the service layer
 *
 * @author bogdan.solga
 */
@SpringBootApplication
public class AsyncProcessingServiceLayerDemo implements CommandLineRunner {

    @Autowired
    private ProductService productService;

    @Override
    public void run(String... strings) throws Exception {
        productService.voidAsyncCall();
        productService.getFuture();

        productService.getListenableFuture();
        productService.getCompletableFuture();
    }

    public static void main(String[] args) {
        new SpringApplication(AsyncProcessingServiceLayerDemo.class).run(args);
    }
}
