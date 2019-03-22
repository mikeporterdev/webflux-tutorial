package dev.mikeporter.coffeeservice;

import dev.mikeporter.coffeeservice.models.Coffee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Component
class DataLoader {
    private final CoffeeRepository repository;

    @Autowired
    DataLoader(final CoffeeRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    private void load() {
        repository.deleteAll().thenMany(
                Flux.just("Americano", "Esmeralda", "Kaldi's Coffee", "Café Olé", "Delta", "Java")
                        .map(name -> new Coffee(UUID.randomUUID().toString(), name))
                        .flatMap(repository::save))
                .thenMany(repository.findAll())
                .subscribe(System.out::println);

    }
}
