package com.nokia.springboot.training.d01.s04;

import com.nokia.springboot.training.d01.s04.config.ComponentModelConfig;
import com.nokia.springboot.training.d01.s04.controller.StoreController;
import com.nokia.springboot.training.d01.s04.model.Store;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StoreServiceDemo {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ComponentModelConfig.class);

        StoreController storeController =
                applicationContext.getBean(StoreController.class);

        Store store = storeController.getStore(5);
        System.out.println("The obtained store has the name '" + store.getName() + "'");
    }
}
