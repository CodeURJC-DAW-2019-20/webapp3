package com.example.demo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
public class Suggestion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String lastname;
	private String email;
	private String message;
	
	public Suggestion() {
		this.setName("");
		this.setLastname("");
		this.setEmail("");
		this.setMessage("");
				
	}
	public Suggestion(String name, String lastname, String email, String message) {
		this.setName(name);
		this.setLastname(lastname);
		this.setEmail(email);
		this.setMessage(message);
				
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	


}
