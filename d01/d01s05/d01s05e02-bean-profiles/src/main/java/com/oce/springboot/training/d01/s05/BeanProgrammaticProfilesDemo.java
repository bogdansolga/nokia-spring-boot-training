package com.oce.springboot.training.d01.s05;

import com.oce.springboot.training.d01.s05.config.BeanProfilesConfig;
import com.oce.springboot.training.d01.s05.config.ProfileEnabledConfig;
import com.oce.springboot.training.d01.s05.config.Profiles;
import com.oce.springboot.training.d01.s05.service.ProductService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * A simple demo of a Spring project to demo the usage of {@link org.springframework.context.annotation.Bean}s
 * activated by the command-line per {@link org.springframework.context.annotation.Profile}s
 *
 * @author bogdan.solga
 */
public class BeanProgrammaticProfilesDemo {

    private static final String PROFILE_ACTIVATION_PROPERTY = "spring.profiles.active";

    // usually passed as a '-Dspring.profiles.active=<profiles>' run argument
    public static void main(String[] args) {
        System.setProperty(PROFILE_ACTIVATION_PROPERTY, Profiles.DEV);

        final AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(BeanProfilesConfig.class, ProfileEnabledConfig.class);

        final ProductService productService = applicationContext.getBean(ProductService.class);
        productService.displayProducts();
    }
}
