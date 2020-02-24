package com.example.demo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String color;
	private String category;
	private String size;
	private String description;
	private String detail;
	private Boolean verify;
	
	public Product() {
		this.setName("");
		this.setColor("");
		this.setCategory("");
		this.setSize("");
		this.setDescription("");
		this.setDetail("");
		this.setVerify(false);
	}
	
	public Product (String name, String color, String category, String size, String description, String detail, Boolean verify) {
		this.setName(name);
		this.setColor(color);
		this.setCategory(category);
		this.setSize(size);
		this.setDescription(description);
		this.setDetail(detail);
		this.setVerify(verify);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Boolean getVerify() {
		return verify;
	}

	public void setVerify(Boolean verify) {
		this.verify = verify;
	}
	
}
