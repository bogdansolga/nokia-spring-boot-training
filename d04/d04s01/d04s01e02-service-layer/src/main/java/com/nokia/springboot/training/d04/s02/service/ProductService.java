package com.nokia.springboot.training.d04.s02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Service
public class ProductService {

    private final AsyncComponent asyncComponent;

    @Autowired
    public ProductService(final AsyncComponent asyncComponent) {
        this.asyncComponent = asyncComponent;
    }

    public void getFuture() {
        final Future<String> futureAsyncValue = asyncComponent.getFutureAsyncValue();

        try {
            getAndDisplayValue(futureAsyncValue);
        } catch (final ExecutionException | InterruptedException e) {
            handleException(e);
        }
    }

    public void getListenableFuture() {
        final ListenableFuture<String> listenableFutureAsyncValue = asyncComponent.getListenableFutureAsyncValue();

        try {
            getAndDisplayValue(listenableFutureAsyncValue);
        } catch (final ExecutionException | InterruptedException e) {
            handleException(e);
        }
    }

    private void getAndDisplayValue(final Future<String> futureValue)
            throws ExecutionException, InterruptedException {

        if (futureValue.isDone()) {
            final String theValue = futureValue.get();
            System.out.println("The " + futureValue.getClass().getSimpleName() + " value is '" + theValue + "'");
        }
    }

    private void handleException(final Exception ex) {
        ex.printStackTrace();
    }
}
