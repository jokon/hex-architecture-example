package com.jarecki.shopdemo.infrastructure.adapter.out;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(
        collection = "users"
)
@Data
public class UserDb {

    @Id
    private UUID id;
    private String name;

    public UserDb(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "UserDb(id=" + this.getId() + ", name=" + this.getName() + ")";
    }
}
