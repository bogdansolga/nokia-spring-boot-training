package com.nokia.springboot.training.d03.s03.repository;

import com.nokia.springboot.training.d03.s03.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
