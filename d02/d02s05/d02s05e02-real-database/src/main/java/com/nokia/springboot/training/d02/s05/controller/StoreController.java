package com.nokia.springboot.training.d02.s05.controller;

import com.nokia.springboot.training.d02.s05.dto.StoreDTO;
import com.nokia.springboot.training.d02.s05.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(
        path = "/store"
)
public class StoreController {

    private final StoreService storeService;

    @Autowired
    public StoreController(final StoreService storeService) {
        this.storeService = storeService;
    }

    @RequestMapping(
            path = "/{id}",
            method = RequestMethod.GET
    )
    public StoreDTO get(@PathVariable final int id) {
        return storeService.get(id);
    }

    @RequestMapping(
            path = "",
            method = RequestMethod.GET
    )
    public Set<StoreDTO> getAll() {
        return storeService.getAll();
    }

    @RequestMapping(
            path = "/name",
            method = RequestMethod.GET
    )// the store with a long name, and with some ! chars in it :)
    public Set<StoreDTO> getStoresByName(
            @RequestParam(value = "storeName") final String storeName,
            @RequestParam(value = "section") final String section) {
        return storeService.getAll();
    }
}
