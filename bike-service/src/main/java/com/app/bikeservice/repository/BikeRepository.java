package com.app.bikeservice.repository;

import com.app.bikeservice.entity.Bike;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface BikeRepository extends ReactiveCrudRepository<Bike,Integer> {
    Mono<Bike> findByUserId(Integer idUser);
}
