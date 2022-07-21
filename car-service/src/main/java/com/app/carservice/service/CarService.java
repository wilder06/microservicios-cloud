package com.app.carservice.service;

import com.app.carservice.entity.Car;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CarService {
    Flux<Car> findAllCars();

    Mono<Car> saveCar(Car car);

    Mono<Car> findByIdCar(Integer id);

    Mono<Car> findByUserId(Integer userId);

}
