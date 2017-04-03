package com.nokia.springboot.training.d04.s02.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Component
public class AsyncComponent {

    @Async
    public ListenableFuture<String> getAsyncValue() {
        return new AsyncResult<>("some value");
    }
}
