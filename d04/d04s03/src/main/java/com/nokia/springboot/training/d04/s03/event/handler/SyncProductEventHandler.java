package com.nokia.springboot.training.d04.s03.event.handler;

import com.nokia.springboot.training.d04.s03.event.ProductRetrievedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SyncProductEventHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(SyncProductEventHandler.class);

    @EventListener
    public void processProduct(final ProductRetrievedEvent productRetrievedEvent) {
        LOGGER.info("The product '{}' was read", productRetrievedEvent.getProductName());
    }
}
