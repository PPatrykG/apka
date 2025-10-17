package com.example.domain;

import com.example.domain.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    void createAndUpdateUser() {
        User u = new User("Alice", "alice@example.com");
        assertNotNull(u.id());
        assertEquals("Alice", u.name());
        assertEquals("alice@example.com", u.email());

        u.updateName("Alicia");
        u.updateEmail("alicia@example.com");

        assertEquals("Alicia", u.name());
        assertEquals("alicia@example.com", u.email());
    }
}
