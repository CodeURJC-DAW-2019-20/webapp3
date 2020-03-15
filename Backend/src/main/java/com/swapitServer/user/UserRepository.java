package com.swapitServer.user;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);
    User findByEmail(String email);
    User findById(String id);
    List<User> findAll();
    Page<User> findAll(Pageable page);
    
}
