package dev.mikeporter.coffeeservice;

import dev.mikeporter.coffeeservice.models.Coffee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

interface CoffeeRepository extends ReactiveCrudRepository<Coffee, String> {

}
