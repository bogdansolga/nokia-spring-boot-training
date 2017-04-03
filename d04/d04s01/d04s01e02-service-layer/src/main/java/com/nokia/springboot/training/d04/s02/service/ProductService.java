package com.nokia.springboot.training.d04.s02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;

@Service
public class ProductService {

    private final AsyncComponent asyncComponent;

    @Autowired
    public ProductService(final AsyncComponent asyncComponent) {
        this.asyncComponent = asyncComponent;
    }

    public void getAsyncValue() {
        final ListenableFuture<String> asyncValue = asyncComponent.getAsyncValue();

        if (asyncValue.isDone()) {
            try {
                final String theValue = asyncValue.get();
                System.out.println("The async returned value is '" + theValue + "'");
            } catch (final ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
