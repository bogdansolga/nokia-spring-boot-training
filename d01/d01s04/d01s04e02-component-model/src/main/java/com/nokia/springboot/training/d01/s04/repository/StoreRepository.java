package com.nokia.springboot.training.d01.s04.repository;

import com.nokia.springboot.training.d01.s04.model.Store;
import org.springframework.stereotype.Repository;

import java.util.HashSet;

@Repository
public class StoreRepository {

    // could have gone into a data
    public Store get(int id) {
        return new Store(id, "Silvia", new HashSet<>());
    }
}
