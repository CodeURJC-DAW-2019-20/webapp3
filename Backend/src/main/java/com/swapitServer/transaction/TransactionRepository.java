package com.swapitServer.transaction;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	List<Transaction> findByUserId(long userId);
	List<Transaction> findByProductId(long productId);
	List<Transaction> findByType(String type);
	Transaction findById(long id);
    
}