package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseUsersLoader {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void initDatabase() {
    	userRepository.save(new User("user", "pass","user lastname","user@swapit","C/ Buenavista 5","Mostoles","España","28358","619865541", 100,  "ROLE_USER"));
		userRepository.save(new User("admin", "adminpass","admin lastname","admin@swapit","C/ Sierra 52","Mostoles","España","28358","699256710", 999999, "ROLE_USER", "ROLE_ADMIN"));
    }

}
