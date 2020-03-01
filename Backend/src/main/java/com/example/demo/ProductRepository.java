package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByName(String name);
    Product findByPrice(long price);
    Product findById(String id);
}
