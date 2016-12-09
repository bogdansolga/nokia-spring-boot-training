package com.oce.springboot.training.d01.s05.service;

import com.oce.springboot.training.d01.s05.config.Profiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * A simple product {@link Service}, which uses the {@link Environment} as an {@link Autowired} collaborator
 *
 * @author bogdan.solga
 */
@Service
public class ProductService {

    // the current environment can be easily autowired
    private final Environment environment;

    @Autowired
    public ProductService(final Environment environment) {
        this.environment = environment;
    }

    public void displayProducts() {
        if (environment.acceptsProfiles(Profiles.PROD)) {
            System.out.println("Running with prod");
        }

        System.out.println("Displaying the products for the '" + Arrays.asList(environment.getActiveProfiles()) + "' profiles...");
    }
}
