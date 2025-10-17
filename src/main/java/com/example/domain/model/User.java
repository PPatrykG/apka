package com.example.domain.model;

import java.util.Objects;
import java.util.UUID;

public class User {
    private final String id;
    private String name;
    private String email;

    public User(String name, String email) {
        this(UUID.randomUUID().toString(), name, email);
    }

    public User(String id, String name, String email) {
        this.id = Objects.requireNonNull(id);
        this.name = Objects.requireNonNull(name);
        this.email = Objects.requireNonNull(email);
    }

    public String id() { return id; }
    public String name() { return name; }
    public String email() { return email; }

    public void updateName(String name) {
        this.name = Objects.requireNonNull(name);
    }

    public void updateEmail(String email) {
        this.email = Objects.requireNonNull(email);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() { return id.hashCode(); }

    @Override
    public String toString() {
        return "User{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", email='" + email + '\'' + '}';
    }
}
