package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface SuggestionRepository extends CrudRepository<Suggestion, Long> {

    Suggestion findByName(String name);
    Suggestion findById(String id);
}
