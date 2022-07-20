package com.app.bikeservice.service;

import com.app.bikeservice.entity.Bike;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BikeService {
    Flux<Bike> findAllBikes();

    Mono<Bike> saveBike(Bike bike);

    Mono<Bike> findByIdBike(Integer id);

    Mono<Bike> findByIdUser(Integer idUser);
}
