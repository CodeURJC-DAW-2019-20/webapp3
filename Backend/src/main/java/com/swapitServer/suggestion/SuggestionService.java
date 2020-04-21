package com.swapitServer.suggestion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class SuggestionService {
	
	@Autowired
	SuggestionRepository suggestionRepository;
	
	public Suggestion getSuggestionById(long id) {
		return suggestionRepository.findById(id);
	}
	
	public Suggestion getSuggestionByName(String name) {
		return suggestionRepository.findByName(name);
	}
	public void saveSuggestion(Suggestion suggestion) {
		suggestionRepository.save(suggestion);
	}
	
	public void deleteSuggestion(long id) {
		suggestionRepository.deleteById(id);
	}
	public void deleteSuggestion(String name) {
		Suggestion aux = getSuggestionByName(name);
		suggestionRepository.deleteById(aux.getId());
	}
	
	public List<Suggestion> getAllSuggestion(){
		return suggestionRepository.findAll();
	}
	public Page<Suggestion> getAllSuggestion(Pageable page){
		return suggestionRepository.findAll(page);
	}
}	

