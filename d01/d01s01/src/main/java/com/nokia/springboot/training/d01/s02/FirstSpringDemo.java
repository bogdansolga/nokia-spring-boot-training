package com.nokia.springboot.training.d01.s02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * A first demo for the usage of a few simple Spring {@link org.springframework.context.annotation.Bean}s
 *
 * @author bogdan.solga
 */
public class FirstSpringDemo {

    public static void main(String[] args) {
        final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DemoConfig.class);

        // retrieving a Spring bean by it's class and using it
        final HelloSpring helloSpring = applicationContext.getBean(HelloSpring.class);
        helloSpring.displayWelcomeMessage();

        // retrieving a bean by it's ID
        //System.out.println(applicationContext.getBean("helloSpring"));
    }
}
