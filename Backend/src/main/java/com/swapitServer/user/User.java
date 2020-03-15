package com.swapitServer.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.*;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.swapitServer.product.Product;

@Entity
@Component
@RequestScope
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(unique = true)
	private String name;

	private String passwordHash;

	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;

	 private String lastname;
	 private String email;
	 private String address;
	 private String city;
	 private String country;
	 private String cp;
	 private String phone;
	 private Integer puntos;
	 private Boolean emailVerified;
	 private Boolean login;

     //@OrderColumn
	// private long[] productsILikeIt;
     
     @OneToMany
     private List<Product> LikekIts;

	 @OneToMany
	 private List<Product> productsBasket;

	// private int itemsILikeIt;
	// private int itemsBasket;

	 //Constructors
	public User() {
	}

	public User(String name, String password, String lastname, String email, String address ,String city , String country , String cp ,String phone, Integer puntos, Boolean Verified, String... roles) {
		this.name = name;
		this.lastname=lastname;
		this.email=email;
		this.address=address;
		this.city=city;
		this.country=country;
		this.cp=cp;
		this.phone=phone;
		this.passwordHash = new BCryptPasswordEncoder().encode(password);
		this.roles = new ArrayList<>(Arrays.asList(roles));
		this.puntos=puntos;
		this.login=false;
		this.emailVerified=Verified;
		this.LikekIts = null;
		this.productsBasket = null;
		
	}
	

	//Setters
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}

	public void setLogin(Boolean login) {
		this.login = login;
	}

	public void setEmailVerified(Boolean emailVerified) {
		this.emailVerified = emailVerified;
	}


	//Getters
	public Long getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}

	public String getPasswordHash() {
		return this.passwordHash;
	}

	public List<String> getRoles() {
		return this.roles;
	}

	public String getLastname() {
		return this.lastname;
	}

	public String getEmail() {
		return this.email;
	}

	public String getAddress() {
		return this.address;
	}

	public String getCity() {
		return this.city;
	}

	public String getCountry() {
		return this.country;
	}

	public String getCp() {
		return this.cp;
	}

	public String getPhone() {
		return this.phone;
	}

	public Integer getPuntos() {
		return this.puntos;
	}

	public Boolean getLogin() {
		return this.login;
	}

	public Boolean getEmailVerified() {
		return this.emailVerified;
	}


	//Functions
	public void updateUserData( String lastname, String email, String address, String city, String country, String cp, String phone) {

		if(lastname != "")
			setLastname(lastname);
		if(email != "")
			setEmail(email);
		if(address != "")
			setAddress(address);
		if(city != "")
			setCity(city);
		if(country != "")
			setCountry(country);
		if(cp != "")
			setCp(cp);
		if(phone != "")
			setPhone(phone);
	}


	public void addProductBasket (Product product){
		this.productsBasket.add(product);
	}

	public List<Product> getLikekIts() {
		return this.LikekIts;
	}

	public void setLikekIts(List<Product> likekIts) {
		this.LikekIts = likekIts;
	}
	
	public void setLikeit(Product product) {
		this.LikekIts.add(product);
	}
	





}