package com.jarecki.shopdemo.domain.ports.in;

import com.jarecki.shopdemo.domain.model.User;
import com.jarecki.shopdemo.domain.model.command.FindUserByIdCommand;

import java.util.Optional;

public interface FindUserByIdUseCase {
    Optional<User> findUserById(FindUserByIdCommand findUserByIdCommand);
}
