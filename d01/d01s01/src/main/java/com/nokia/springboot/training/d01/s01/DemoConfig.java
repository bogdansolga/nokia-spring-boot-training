package com.nokia.springboot.training.d01.s01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Sample Spring configuration, which exposes two simple {@link Bean}s
 *
 * @author bogdan.solga
 */
@Configuration
public class DemoConfig {

    @Bean
    public String helloSpringAsString() {
        return "Hello, Spring!";
    }

    @Bean
    public HelloSpring helloSpring() {
        return new HelloSpring();
    }

    /**
     * This bean is commented by default, so that we won't have two beans of the same type in the Spring IoC container
     */
    //@Bean
    public HelloSpring otherHelloSpring() {
        return new HelloSpring();
    }
}
