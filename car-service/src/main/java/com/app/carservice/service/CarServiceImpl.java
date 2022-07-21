package com.app.carservice.service;

import com.app.carservice.entity.Car;
import com.app.carservice.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CarServiceImpl implements  CarService{

    @Autowired
    private CarRepository carRepository;
    @Override
    public Flux<Car> findAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Mono<Car> saveCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Mono<Car> findByIdCar(Integer id) {
        return carRepository.findById(id);
    }

    @Override
    public Mono<Car> findByUserId(Integer userId) {
        return carRepository.findByUserId(userId);
    }
}
