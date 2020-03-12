package com.swapitServer.suggestion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swapitServer.product.Product;


@RestController
@RequestMapping("/api/suggestion")
public class SuggestionRestController {
	

	@Autowired
	private SuggestionService suggestionService;

	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ResponseEntity<Suggestion> registerSuggestion(@RequestBody Suggestion suggestion) {	
			suggestionService.saveSuggestion(new Suggestion(suggestion.getName(),suggestion.getLastname(),suggestion.getEmail(),suggestion.getMessage()));	
			return new ResponseEntity<>(suggestion,HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/", method=RequestMethod.DELETE)
	public ResponseEntity<Product> deleteSuggestion(@RequestParam long id) {	
		if(suggestionService.getSuggestionById(id) != null) {
			suggestionService.deleteSuggestion(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<List<Suggestion>> readAllSuggestion() {				
			return new ResponseEntity<>(suggestionService.getAllSuggestion(),HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<Suggestion>> readAllSuggestion(Pageable page) {				
			return new ResponseEntity<>(suggestionService.getAllSuggestion(page),HttpStatus.CREATED);
	}
	

}
