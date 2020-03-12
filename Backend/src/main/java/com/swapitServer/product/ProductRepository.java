package com.swapitServer.product;


import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByName(String name);
    Product findByPrice(long price);
    Product findById(long id);
    List<Product> findByVerifyAndInStockOrderByCategoryDesc(Boolean verify, Boolean inStock);
    Page<Product> findByVerifyAndInStockOrderByCategoryDesc(Boolean verify, Boolean inStock, Pageable pageable);
}
