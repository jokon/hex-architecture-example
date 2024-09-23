package com.jarecki.shopdemo.domain.ports.in;

import com.jarecki.shopdemo.domain.model.User;

import java.util.List;

public interface GetAllUsersUseCase {
    List<User> getAll();
}
