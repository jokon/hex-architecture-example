package com.jarecki.shopdemo.domain.core;

import com.jarecki.shopdemo.domain.model.User;
import com.jarecki.shopdemo.domain.model.command.CreateUserCommand;
import com.jarecki.shopdemo.domain.model.command.FindUserByIdCommand;
import com.jarecki.shopdemo.domain.model.command.FindUserByNameCommand;
import com.jarecki.shopdemo.domain.ports.in.CreateUserUseCase;
import com.jarecki.shopdemo.domain.ports.in.FindUserByIdUseCase;
import com.jarecki.shopdemo.domain.ports.in.FindUserByNameUseCase;
import com.jarecki.shopdemo.domain.ports.in.GetAllUsersUseCase;
import com.jarecki.shopdemo.domain.ports.out.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class DomainUserFacade implements CreateUserUseCase, FindUserByNameUseCase, FindUserByIdUseCase, GetAllUsersUseCase {

    private final UserRepository userRepository;

    public DomainUserFacade(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UUID handle(CreateUserCommand command) {
        UUID id = UUID.randomUUID();
        userRepository.save(new User(id, command.name()));
        return id;
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll().stream().map(userDb -> new User(userDb.getId(), userDb.getName())).toList();
    }

    @Override
    public Optional<User> findUserById(FindUserByIdCommand findUserByIdCommand) {
        return userRepository.findById(findUserByIdCommand.id()).map(userDb -> new User(userDb.getId(), userDb.getName()));
    }

    @Override
    public List<User> findUserByName(FindUserByNameCommand command) {
        return userRepository.findByName(command.name()).stream().map(userDb -> new User(userDb.getId(), userDb.getName())).toList();
    }

}
