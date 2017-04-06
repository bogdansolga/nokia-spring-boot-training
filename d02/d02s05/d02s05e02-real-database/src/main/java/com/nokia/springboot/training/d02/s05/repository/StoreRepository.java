package com.nokia.springboot.training.d02.s05.repository;

import com.nokia.springboot.training.d02.s05.model.Store;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends CrudRepository<Store, Integer> {
}
