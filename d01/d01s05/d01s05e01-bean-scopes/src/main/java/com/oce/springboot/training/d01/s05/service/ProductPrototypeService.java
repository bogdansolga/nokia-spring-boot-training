package com.oce.springboot.training.d01.s05.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * An example of a 'prototype' scoped {@link Service}
 */
@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProductPrototypeService {

    public void displayHashCode() {
        System.out.println("The hashCode for this instance is " + hashCode());
    }
}
