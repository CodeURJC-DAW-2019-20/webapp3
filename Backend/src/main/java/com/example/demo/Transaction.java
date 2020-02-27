package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="intercambios")

@Entity
public class Transaction {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	

	
	
	
	protected Transaction(){
		
	}

	public Transaction(long id) {
		super();
		this.id = id;
	}
	
	

}
