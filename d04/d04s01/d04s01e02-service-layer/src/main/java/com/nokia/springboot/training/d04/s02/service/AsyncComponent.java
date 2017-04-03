package com.nokia.springboot.training.d04.s02.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.Future;

@Component
public class AsyncComponent {

    @Async
    public Future<String> getFutureAsyncValue() {
        return new AsyncResult<>("Returning a Future async value");
    }

    @Async
    public ListenableFuture<String> getListenableFutureAsyncValue() {
        return new AsyncResult<>("Returning a ListenableFuture async value");
    }
}
