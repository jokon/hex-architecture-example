package com.jarecki.shopdemo.infrastructure.adapter.out;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(
        collection = "orders"
)
@Data
public class OrderDb {

    @Id
    private UUID id;

    public OrderDb(UUID id) {
        this.id = id;
    }

    public String toString() {
        return "OrderDb(id=" + this.getId() + ")";
    }

}
