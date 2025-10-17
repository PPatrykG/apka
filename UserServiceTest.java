package com.example.application;

import com.example.application.service.UserService;
import com.example.domain.exceptions.UserNotFoundException;
import com.example.domain.model.User;
import com.example.inmemory.InMemoryUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class UserServiceTest {

    private UserService service;
    private InMemoryUserRepository repo;

    @BeforeEach
    void setup() {
        repo = new InMemoryUserRepository();
        service = new UserService(repo);
    }

    @Test
    void createAndGetUser() {
        User created = service.create("Bob", "bob@example.com");
        assertThat(created.id()).isNotNull();
        User fetched = service.getById(created.id());
        assertThat(fetched).isEqualTo(created);
    }

    @Test
    void updateUser() {
        User created = service.create("Carol", "carol@example.com");
        User updated = service.update(created.id(), "Caroline", null);
        assertThat(updated.name()).isEqualTo("Caroline");
        assertThat(updated.email()).isEqualTo("carol@example.com");
    }

    @Test
    void deleteUser() {
        User created = service.create("Dave", "dave@example.com");
        service.delete(created.id());
        assertThatThrownBy(() -> service.getById(created.id()))
            .isInstanceOf(UserNotFoundException.class);
    }
}
