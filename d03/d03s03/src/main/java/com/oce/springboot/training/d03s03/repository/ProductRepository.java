package com.oce.springboot.training.d03s03.repository;

import com.oce.springboot.training.d03s03.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
