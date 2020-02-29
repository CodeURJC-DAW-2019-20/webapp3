package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.swing.*;
import javax.swing.text.Document;

import org.springframework.stereotype.Component;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

@Entity
@Component
public class Product {
	//Constants
	static final int PRICE_BASE_COAT = 600;
	static final int PRICE_BASE_ACCESSORY = 50;
	static final int PRICE_BASE_BOATS = 500;
	static final int PRICE_BASE_SHIRT = 300;
	static final int PRICE_BASE_TSHIRT = 200;
	static final int PRICE_BASE_JACKET = 400;
	static final int PRICE_BASE_SKIRT = 180;
	static final int PRICE_BASE_SWEATER = 200;
	static final int PRICE_BASE_JEANS = 500;
	static final int PRICE_BASE_SNEAKERS = 400;
	static final int PRICE_BASE_SHOES = 600;

	static final float  MULTIPLIER_LOW = 0.7f;
	static final float  MULTIPLIER_NORMAL = 1f;
	static final float  MULTIPLIER_HIGH = 1.5f;
	static final float  MULTIPLIER_PREMIUM = 2.2f;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String color;
	private String category;
	private String brand;
	private String size;
	private float price;
	private String description;
	private String detail;
	private Boolean verify;
	private Boolean image;

	
	public Product() {
		this.setName("");
		this.setColor("");
		this.setCategory("");
		this.setBrand("");
		this.setSize("");
		this.setPrice();
		this.setDescription("");
		this.setDetail("");
		this.setVerify(false);
		this.setImage(false);
	}
	
	public Product (String name, String color, String category, String brand, String size, String description, String detail, Boolean verify) {
		this.setName(name);
		this.setColor(color);
		this.setCategory(category);
		this.setBrand(brand);
		this.setSize(size);
		this.setPrice();
		this.setDescription(description);
		this.setDetail(detail);
		this.setVerify(verify);
	}

	public Long getId(){
		return this.id;
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

	public void setBrand(String brand){this.brand = brand;}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public float getPrice (){
		return price;
	}

	public String getDescription() {
		return description;
	}

	public void setPrice() {
		this.price = priceCategory() * priceBrand();
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

	public void setImage (Boolean status){
		this.image = status;
	}

	public boolean getImage (){
		return this.image;
	}

	public boolean hasImage () {
		return this.image;
	}

	public int priceCategory (){
		switch (this.category){
			case "1": //Coat
				return PRICE_BASE_COAT;

			case "2": //Accesory
				return PRICE_BASE_ACCESSORY;

			case "3": //Boats
				return PRICE_BASE_BOATS;

			case "4": //Shirt
				return PRICE_BASE_SHIRT;

			case "5": //Tshirt
				return PRICE_BASE_TSHIRT;

			case "6": //Jacket
				return PRICE_BASE_JACKET;

			case "7": //Skirt
				return PRICE_BASE_SKIRT;

			case "8": //Sweater
				return PRICE_BASE_SWEATER;

			case "9": //Jeans
				return PRICE_BASE_JEANS;

			case "10": //Sneakers
				return PRICE_BASE_SNEAKERS;

			case "11": //Shoes
				return PRICE_BASE_SHOES;
		}
		return 1;
	}

	public float priceBrand (){
		switch (this.brand){
			case "8": //Lefties
			case "10": //Primark
				return MULTIPLIER_LOW;

			case "4": //C&A
			case "6": //HyM
			case "11": //PullAndBear
			case "12": //Puma
			case "16": //Otra
				return MULTIPLIER_NORMAL;

			case "1": //Adidas
			case "9": //Nike
			case "15": //Zara
				return MULTIPLIER_HIGH;

			case "2": //Armani
			case "3": //Calvin Klein
			case "5": //Hollister
			case "7": //Lacoste
			case "13": //Ralph Lauren
			case "14": //TH
				return MULTIPLIER_PREMIUM;
		}
		return 1;
	}
}
