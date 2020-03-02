package com.example.demo;

import javax.annotation.PostConstruct;
import javax.persistence.*;

import org.springframework.stereotype.Component;



@Entity
@Component
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

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

	@OneToOne
	private User owner;
	
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
		super ();
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

	public void setImage (boolean image){
	    this.image = image;
    }

	public boolean getImage (){
		return this.image;
	}

	public boolean hasImage () {
		return this.image;
	}

	public void setOwner(User user){
		this.owner = user;
	}

	public User getOwner (){
		return this.owner;
	}

	public long getIdOfOwner (){
		return this.owner.getId();
	}

	public int priceCategory (){
		switch (this.category){
			case "Abrigo": //Coat
				return PRICE_BASE_COAT;

			case "Accesorio": //Accesory
				return PRICE_BASE_ACCESSORY;

			case "Bota": //Boats
				return PRICE_BASE_BOATS;

			case "Camisa": //Shirt
				return PRICE_BASE_SHIRT;

			case "Camiseta": //Tshirt
				return PRICE_BASE_TSHIRT;

			case "Chaqueta": //Jacket
				return PRICE_BASE_JACKET;

			case "Falda": //Skirt
				return PRICE_BASE_SKIRT;

			case "Jersey": //Sweater
				return PRICE_BASE_SWEATER;

			case "Vaquero": //Jeans
				return PRICE_BASE_JEANS;

			case "Zapatilla": //Sneakers
				return PRICE_BASE_SNEAKERS;

			case "Zapato": //Shoes
				return PRICE_BASE_SHOES;
		}
		return 1;
	}

	public float priceBrand (){
		switch (this.brand){
			case "Lefties": //Lefties
			case "Primark": //Primark
				return MULTIPLIER_LOW;

			case "C&A": //C&A
			case "HyM": //HyM
			case "PullAndBear": //PullAndBear
			case "Puma": //Puma
			case "Other": //Otra
				return MULTIPLIER_NORMAL;

			case "Adidas": //Adidas
			case "Nike": //Nike
			case "Zara": //Zara
				return MULTIPLIER_HIGH;

			case "Armani": //Armani
			case "CalvinKlein": //Calvin Klein
			case "Hollister": //Hollister
			case "Lacoste": //Lacoste
			case "RalphLauren": //Ralph Lauren
			case "TH": //TH
				return MULTIPLIER_PREMIUM;
		}
		return 1;
	}
}
