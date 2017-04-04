package com.nokia.springboot.training.d01.s04.controller;

import com.nokia.springboot.training.d01.s04.model.Store;
import com.nokia.springboot.training.d01.s04.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class StoreController {

    private final StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    public Store getStore(final int id) {
        return storeService.get(id);
    }
}
