package com.swapitServer.product;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByName(String name);
    Product findByPrice(long price);
    //Product findByIdd(long id);
    Product findById(long id);
}
