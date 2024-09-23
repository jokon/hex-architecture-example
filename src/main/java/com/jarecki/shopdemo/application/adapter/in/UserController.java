package com.jarecki.shopdemo.application.adapter.in;

import com.jarecki.shopdemo.application.response.CreateUserResponse;
import com.jarecki.shopdemo.domain.model.User;
import com.jarecki.shopdemo.domain.core.UserFacade;
import com.jarecki.shopdemo.domain.model.command.CreateUserCommand;
import com.jarecki.shopdemo.domain.model.command.FindUserByIdCommand;
import com.jarecki.shopdemo.domain.model.command.FindUserByNameCommand;
import com.jarecki.shopdemo.domain.ports.in.CreateUserUseCase;
import com.jarecki.shopdemo.domain.ports.in.FindUserByIdUseCase;
import com.jarecki.shopdemo.domain.ports.in.FindUserByNameUseCase;
import com.jarecki.shopdemo.domain.ports.in.GetAllUsersUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final FindUserByIdUseCase findUserByIdUseCase;
    private final FindUserByNameUseCase findUserByNameUseCase;
    private final GetAllUsersUseCase getAllUsersUseCase;

    public UserController(UserFacade userService, CreateUserUseCase createUserUseCase,
                          FindUserByIdUseCase findUserByIdUseCase, FindUserByNameUseCase findUserByNameUseCase,
                          GetAllUsersUseCase getAllUsersUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.findUserByIdUseCase = findUserByIdUseCase;
        this.findUserByNameUseCase = findUserByNameUseCase;
        this.getAllUsersUseCase = getAllUsersUseCase;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable UUID id) {
        return findUserByIdUseCase.findUserById(new FindUserByIdCommand(id)).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/")
    public List<User> findUserByName(@RequestParam(value = "name", required = false) String name) {
        if (name != null) {
            return findUserByNameUseCase.findUserByName(new FindUserByNameCommand(name));
        }
        return getAllUsersUseCase.getAll();
    }

    @PostMapping
    public CreateUserResponse createUser(@RequestParam String name) {
        final UUID id = createUserUseCase.handle(new CreateUserCommand(name));
        return new CreateUserResponse(id);
    }
}
