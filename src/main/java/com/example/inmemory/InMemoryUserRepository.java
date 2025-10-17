package com.example.inmemory;

import com.example.domain.model.User;
import com.example.domain.repository.UserRepository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryUserRepository implements UserRepository {

    private final Map<String, User> storage = new ConcurrentHashMap<>();

    @Override
    public User save(User user) {
        storage.put(user.id(), user);
        return user;
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void deleteById(String id) {
        storage.remove(id);
    }

    @Override
    public boolean existsById(String id) {
        return storage.containsKey(id);
    }
}
