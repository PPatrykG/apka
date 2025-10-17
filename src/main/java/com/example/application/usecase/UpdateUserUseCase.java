package com.example.application.usecase;

import com.example.domain.model.User;

public interface UpdateUserUseCase {
    User update(String id, String newName, String newEmail);
}
