package com.jarecki.shopdemo.domain.ports.in;

import com.jarecki.shopdemo.domain.model.User;
import com.jarecki.shopdemo.domain.model.command.FindUserByNameCommand;

import java.util.List;

public interface FindUserByNameUseCase {
    List<User> findUserByName(FindUserByNameCommand name);
}
