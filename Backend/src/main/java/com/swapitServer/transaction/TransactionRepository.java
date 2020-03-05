package com.swapitServer.transaction;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {

	List<Transaction> findByUserId(long userId);
	List<Transaction> findByProductId(long productId);
	List<Transaction> findByType(String type);
	Transaction findById(long id);
    
}