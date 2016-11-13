package com.oce.springboot.training.d01.s04;

import com.oce.springboot.training.d01.s04.config.BeanAliasingConfig;
import com.oce.springboot.training.d01.s04.repository.ProductRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * A simple demo of a Spring project to demo the {@link org.springframework.context.annotation.Bean} aliasing
 *
 * @author bogdan.solga
 */
public class BeanAliasingDemo {

    public static void main(String[] args) {
        final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanAliasingConfig.class);

        final ProductRepository productRepository = applicationContext.getBean("prodRepo", ProductRepository.class);//ProductRepository.class);
        productRepository.displayProducts();
    }
}
