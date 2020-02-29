package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.ArrayList;

@Component
public class DatabaseLoader {

    @Autowired
    private UserRepository userRepository;
    private ProductRepository productRepository;

    @PostConstruct
    private void initDatabase() {
    	userRepository.save(new User("user", "pass","user lastname","user@swapit","C/ Buenavista 5","Mostoles","España","28358","619865541", 100, true,  "ROLE_USER"));
		userRepository.save(new User("admin", "adminpass","admin lastname","admin@swapit","C/ Sierra 52","Mostoles","España","28358","699256710", 999999, true,"ROLE_USER", "ROLE_ADMIN"));


    }

}
