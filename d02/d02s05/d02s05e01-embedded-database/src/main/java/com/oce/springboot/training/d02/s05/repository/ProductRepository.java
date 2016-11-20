package com.oce.springboot.training.d02.s05.repository;

import com.oce.springboot.training.d02.s05.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * A simple Spring Data {@link CrudRepository} for the {@link Product} entity
 *
 * @author bogdan.solga
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
