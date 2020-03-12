package com.swapitServer.suggestion;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SuggestionRepository extends JpaRepository<Suggestion, Long> {

    Suggestion findByName(String name);
    Suggestion findById(long id);
    List<Suggestion> findAll();
    Page<Suggestion> findAll(Pageable page);
}
