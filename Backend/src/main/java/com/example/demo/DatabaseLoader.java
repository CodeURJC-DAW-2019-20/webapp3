package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DatabaseLoader {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private SuggestionRepository suggestionRepository;

    @PostConstruct
    private void initDatabase() throws IOException {
    	// USER
    	userRepository.save(new User("admin", "adminpass","admin lastname","admin@swapit","C/ Sierra 52","Mostoles","España","28358","699256710", 999999, true,  "ROLE_USER",  "ROLE_ADMIN"));
    	userRepository.save(new User("user", "pass","user lastname","user@swapit","C/ Buenavista 5","Mostoles","España","28358","619865541", 100, true, "ROLE_USER"));
		
		//PRODUCTS
		productRepository.save(new Product("Sudadera Capucha", "Multi", "Jersey", "PullAndBear", "M", "", "",  false,true));
        productRepository.save(new Product("Jersey Mostaza", "Mostaza", "Jersey", "Zara", "S", "", "",  false,true));
        productRepository.save(new Product("Jersey Azul", "Azul", "Jersey", "Calvin Klein", "M", "", "",  false,true));
        productRepository.save(new Product("Jersey Burdeos", "Burdeos", "Jersey", "Zara", "M", "", "",  false,true));
        productRepository.save(new Product("Jersey Blanco", "Blanco", "Jersey", "HyM", "M", "", "",  false,true));
        productRepository.save(new Product("Jersey Gris", "Gris", "Jersey", "Primark", "M", "", "",  false,true));
        productRepository.save(new Product("Jersey Rosa", "Rosa", "Jersey", "Lefties", "M", "", "",  false,true));
        productRepository.save(new Product("Jersey A Rayas", "Multi", "Jersey", "Primark", "M", "", "",  false,true));
        productRepository.save(new Product("Camisa Pana", "Azul", "Camisa", "PullAndBear", "M", "", "",  false,true));
        
        //TRANSACTIONS
        transactionRepository.save(new Transaction("BUY",(long)2,(long)4));
		transactionRepository.save(new Transaction("BUY",(long)2,(long)5,"01/03/2020"));
		transactionRepository.save(new Transaction("BUY",(long)2,(long)7,"01/03/2020"));
		transactionRepository.save(new Transaction("SELL",(long)2,(long)6));
		
		transactionRepository.save(new Transaction("BUY",(long)2,(long)8,"29/02/2020"));
		transactionRepository.save(new Transaction("BUY",(long)2,(long)8,"29/02/2020"));
		transactionRepository.save(new Transaction("BUY",(long)2,(long)8,"29/02/2020"));
		transactionRepository.save(new Transaction("BUY",(long)2,(long)8,"29/02/2020"));
		//SUGGESTIONS
    	suggestionRepository.save(new Suggestion("Alberto","Garcia","AlbG@hotmail.com","La pagina pagina tiene muchos errore"));
   
    }
}
