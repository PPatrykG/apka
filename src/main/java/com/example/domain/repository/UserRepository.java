package com.example.domain.repository;

import com.example.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(String id);
    List<User> findAll();
    void deleteById(String id);
    boolean existsById(String id);
}
