package com.oce.springboot.training.d01.s06;

import com.oce.springboot.training.d01.s06.config.BeanProfilesConfig;
import com.oce.springboot.training.d01.s06.service.ProductService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * An example of how to load and use .properties files
 */
public class PropertiesLoadingDemo {

    public static void main(String[] args) {
        final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanProfilesConfig.class);

        final ProductService productService = applicationContext.getBean(ProductService.class);
        productService.displayLoadedProperties();
    }
}
