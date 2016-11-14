package com.oce.springboot.training.d01.s05;

import com.oce.springboot.training.d01.s05.config.BeanProfilesConfig;
import com.oce.springboot.training.d01.s05.config.ProfileEnabledConfig;
import com.oce.springboot.training.d01.s05.config.Profiles;
import com.oce.springboot.training.d01.s05.service.ProductService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * A simple demo of a Spring project to demo the usage of {@link org.springframework.context.annotation.Bean}
 * activated pragmatically per {@link org.springframework.context.annotation.Profile}s
 *
 * @author bogdan.solga
 */
public class BeanCommandLineProfilesDemo {

    public static void main(String[] args) {
        // we need to set the profile before registering the config class
        final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.getEnvironment().setActiveProfiles(Profiles.DEV);
        applicationContext.register(BeanProfilesConfig.class, ProfileEnabledConfig.class);
        applicationContext.refresh();

        final ProductService productService = applicationContext.getBean(ProductService.class);
        productService.displayProducts();
    }
}
