package dev.mikeporter.coffeeservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoffeeOrder {
    private String coffeeId;
    private Instant dateOrdered;
}
