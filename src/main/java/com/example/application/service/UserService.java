package com.example.application.service;

import com.example.application.usecase.*;
import com.example.domain.exceptions.UserNotFoundException;
import com.example.domain.model.User;
import com.example.domain.repository.UserRepository;

import java.util.Objects;

public class UserService implements CreateUserUseCase, GetUserUseCase, UpdateUserUseCase, DeleteUserUseCase {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = Objects.requireNonNull(repository);
    }

    @Override
    public User create(String name, String email) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name cannot be empty");
        if (email == null || email.isBlank()) throw new IllegalArgumentException("Email cannot be empty");
        User user = new User(name, email);
        return repository.save(user);
    }

    @Override
    public User getById(String id) {
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public User update(String id, String newName, String newEmail) {
        User u = repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        if (newName != null && !newName.isBlank()) u.updateName(newName);
        if (newEmail != null && !newEmail.isBlank()) u.updateEmail(newEmail);
        return repository.save(u);
    }

    @Override
    public void delete(String id) {
        if (!repository.existsById(id)) throw new UserNotFoundException(id);
        repository.deleteById(id);
    }
}
