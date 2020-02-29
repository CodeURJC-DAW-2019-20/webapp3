package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.swing.*;

import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.ArrayList;

@Entity
@Component
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String color;
	private String category;
	private String size;
	private int price;
	private String description;
	private String detail;
	private Boolean verify;
	private ArrayList<ImageIcon> pictureList;
	
	public Product() {
		this.setName("");
		this.setColor("");
		this.setCategory("");
		this.setSize("");
		this.setPrice(0);
		this.setDescription("");
		this.setDetail("");
		this.setVerify(false);
		this.pictureList = new ArrayList<>();
	}
	
	public Product (String name, String color, String category, String size, int price, String description, String detail, Boolean verify, ImageIcon img) {
		this.setName(name);
		this.setColor(color);
		this.setCategory(category);
		this.setSize(size);
		this.setPrice(price);
		this.setDescription(description);
		this.setDetail(detail);
		this.setVerify(verify);
		this.pictureList.add(img);
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

	public int getPrice (){
		return price;
	}

	public String getDescription() {
		return description;
	}

	public void setPrice(int price) {
		this.price = price;
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
