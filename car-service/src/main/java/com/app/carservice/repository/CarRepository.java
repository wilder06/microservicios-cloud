package com.app.carservice.repository;

import com.app.carservice.entity.Car;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CarRepository extends ReactiveCrudRepository<Car, Integer> {
    Mono<Car> findByUserId(Integer userId);

}
