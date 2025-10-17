package com.example.application.usecase;

import com.example.domain.model.User;

public interface GetUserUseCase {
    User getById(String id);
}
