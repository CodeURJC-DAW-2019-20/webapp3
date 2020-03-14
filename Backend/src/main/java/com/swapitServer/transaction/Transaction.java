package com.swapitServer.transaction;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Component
@RequestScope
public class Transaction {
	
	static final String pattern = "dd/MM/yyyy";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	private String type;	
	private Long productId;	
	private Long userId;
	private String date;

	public Transaction() {
		this.setType("NULL");
		this.setProductId((long)-1);		
		this.setUserId((long)-1);
	}
	
	public Transaction(String type, Long userId, Long productId) {
		this.setType(type);
		this.setProductId(productId);		
		this.setUserId(userId);
		
		this.date =  new SimpleDateFormat(pattern).format(new Date()).toString();
	}
	
	public Transaction(String type, Long userId, Long productId, String date) {
		this.setType(type);
		this.setProductId(productId);		
		this.setUserId(userId);		
		this.date =  date;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getDate() {
		return this.date;
	}

}
