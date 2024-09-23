package com.jarecki.shopdemo.domain.ports.in;

import com.jarecki.shopdemo.domain.model.command.CreateUserCommand;

import java.util.UUID;

public interface CreateUserUseCase {
    UUID handle(CreateUserCommand command);
}
