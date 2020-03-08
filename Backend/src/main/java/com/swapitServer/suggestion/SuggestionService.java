package com.swapitServer.suggestion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SuggestionService {
	
	@Autowired
	SuggestionRepository suggestionRepository;
	
	public Suggestion getSuggestionById(long id) {
		return suggestionRepository.findById(id);
	}
	public void saveSuggestion(Suggestion suggestion) {
		suggestionRepository.save(suggestion);
	}
	
	public void deleteSuggestion(long id) {
		suggestionRepository.deleteById(id);
	}
	
	public List<Suggestion> getAllSuggestion(){
		return suggestionRepository.findAll();
	}
}	

