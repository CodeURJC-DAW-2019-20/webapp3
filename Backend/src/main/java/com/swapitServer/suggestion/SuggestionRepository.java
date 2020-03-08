package com.swapitServer.suggestion;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SuggestionRepository extends CrudRepository<Suggestion, Long> {

    Suggestion findByName(String name);
    Suggestion findById(long id);
    List<Suggestion> findAll();
}
