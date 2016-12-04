package com.oce.springboot.training.d01.s01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * A first demo for the usage of a few simple Spring {@link org.springframework.context.annotation.Bean}s
 *
 * @author bogdan.solga
 */
public class HelloSpring {

    public static void main(String[] args) {
        final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DemoConfig.class);

        // retrieving a Spring bean by it's class and using it
        final FirstSpringBean firstSpringBean = applicationContext.getBean(FirstSpringBean.class);
        firstSpringBean.displayDescription();

        // retrieving a bean by it's ID
        //System.out.println(applicationContext.getBean("helloSpring"));
    }
}
