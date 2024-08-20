package com.jarecki.shopdemo.application.port;

import com.jarecki.shopdemo.application.response.CreateUserResponse;
import com.jarecki.shopdemo.domain.model.User;
import com.jarecki.shopdemo.domain.repository.UserRepository;
import com.jarecki.shopdemo.domain.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findUserById(@PathVariable UUID id) {
        return userService.findUserById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public CreateUserResponse createUser(@RequestParam String name) {
        final UUID id = userService.createUser(name);
        return new CreateUserResponse(id);
    }
}
