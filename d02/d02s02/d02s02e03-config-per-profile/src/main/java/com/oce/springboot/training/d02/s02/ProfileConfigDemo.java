package com.oce.springboot.training.d02.s02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProfileConfigDemo {

    public static void main(String[] args) {
        final SpringApplication springApplication = new SpringApplication(ProfileConfigDemo.class);

        // running without a profile will throw an exception, as the property doesn't exist in the default config
        //springApplication.setAdditionalProfiles(Profiles.PROD);

        springApplication.run(args);
    }
}
