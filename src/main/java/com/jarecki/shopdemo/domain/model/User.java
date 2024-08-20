package com.jarecki.shopdemo.domain.model;

import lombok.Data;

import java.util.UUID;

@Data
public class User {
    private UUID id;
    private String name;

    public User(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
}
