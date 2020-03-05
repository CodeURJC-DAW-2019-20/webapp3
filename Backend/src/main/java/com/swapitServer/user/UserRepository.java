package com.swapitServer.user;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByName(String name);
    User findByEmail(String email);
    User findById(String id);
    List<User> findAll();
}
