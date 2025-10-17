package com.example.application.usecase;

import com.example.domain.model.User;

public interface CreateUserUseCase {
    User create(String name, String email);
}
