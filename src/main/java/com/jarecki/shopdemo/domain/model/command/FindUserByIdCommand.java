package com.jarecki.shopdemo.domain.model.command;

import java.util.UUID;

public record FindUserByIdCommand(UUID id) {
}
