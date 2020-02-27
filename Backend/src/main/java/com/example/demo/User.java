package com.example.demo;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


@Table(name="clientes")

@Entity
@Component
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

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

	 
	 private Boolean login;

	
	public User() {
	}

	public User(String name, String password, String lastname, String email, String address ,String city , String country , String cp ,String phone, Integer puntos, String... roles) {
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
	}
	

	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}


	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		country = country;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getPuntos() {
		return puntos;
	}

	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}

	public Boolean getLogin() {
		return login;
	}

	public void setLogin(Boolean login) {
		this.login = login;
	}

	public void updateData( String lastname, String email, String address, String city, String country, String cp, String phone) {

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

}