package com.nokia.springboot.training.d03.s04.repository;

import com.nokia.springboot.training.d03.s04.model.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * A simple Spring Data {@link CrudRepository} for the {@link Product} entity
 *
 * @author bogdan.solga
 */
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
