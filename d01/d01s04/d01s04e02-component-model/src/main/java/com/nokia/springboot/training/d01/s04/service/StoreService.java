package com.nokia.springboot.training.d01.s04.service;

import com.nokia.springboot.training.d01.s04.model.Store;
import com.nokia.springboot.training.d01.s04.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StoreService {

    // each of these services will have CRUD methods for the processed model

    @Autowired(required = false) // --> makes the wired bean optional
    private StoreRepository storeRepository;

    public Store get(int id) {
        return storeRepository.get(id);
    }
}
