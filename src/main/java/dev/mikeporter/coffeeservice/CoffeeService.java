package dev.mikeporter.coffeeservice;

import dev.mikeporter.coffeeservice.models.Coffee;
import dev.mikeporter.coffeeservice.models.CoffeeOrder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.Instant;

@Service
public class CoffeeService {
    private final CoffeeRepository repo;

    CoffeeService(final CoffeeRepository repo) {
        this.repo = repo;
    }

    Flux<Coffee> getAllCoffees() {
        return repo.findAll();
    }

    Mono<Coffee> getCoffeeById(final String id) {
        return repo.findById(id);
    }

    Flux<CoffeeOrder> getOrders(String coffeeId) {
        return Flux.<CoffeeOrder>generate(sink -> sink.next(new CoffeeOrder(coffeeId, Instant.now())))
                .delayElements(Duration.ofSeconds(1));
    }
}
