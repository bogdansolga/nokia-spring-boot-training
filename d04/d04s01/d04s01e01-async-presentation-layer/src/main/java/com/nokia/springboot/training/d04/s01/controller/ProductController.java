package com.nokia.springboot.training.d04.s01.controller;

import com.nokia.springboot.training.d04.s01.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(
        path = "/product",
        method = RequestMethod.GET
)
public class ProductController {

    @RequestMapping(
            path = "/sync/{id}"
    )
    public Product getProduct(@PathVariable final int id) {
        return new Product(10, "Tablet");
    }

    @RequestMapping(
            path = "/async/{id}"
    )
    public DeferredResult<ResponseEntity<?>> getAsyncProduct(@PathVariable final int id) {
        final DeferredResult<ResponseEntity<?>> deferredResult = new DeferredResult<>();

        CompletableFuture
                .supplyAsync(() -> new Product(10, "Tablet"))
                .whenCompleteAsync((response, error) -> processAsyncResponse(deferredResult, response, error));

        return deferredResult;
    }

    private void processAsyncResponse(final DeferredResult<ResponseEntity<?>> deferred, final Object response,
                                      final Throwable error) {
        if (error == null) {
            deferred.setResult(ResponseEntity.ok(response));
        } else {
            deferred.setErrorResult(error);

            /*
            final ResponseEntity<String> responseEntity = new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
            deferred.setResult(responseEntity);
            deferred.onTimeout(() -> deferred.setResult(responseEntity));
            */
        }
    }
}
