package com.swapitServer.suggestion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SuggestionService {
	
	@Autowired
	SuggestionRepository suggestionRepository;
	
	public void saveSuggestion(Suggestion suggestion) {
		suggestionRepository.save(suggestion);
	}
	
	public void deleteSuggestion(String id) {
		suggestionRepository.deleteById(Long.parseLong(id));
	}
	
	public List<Suggestion> getAllSuggestion(){
		return suggestionRepository.findAll();
	}
}	

