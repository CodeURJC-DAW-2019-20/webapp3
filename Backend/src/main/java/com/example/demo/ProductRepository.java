package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

    Product findByName(String name);
    Product findByPrice(long price);
    Product findById(String id);
}
