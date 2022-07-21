package com.app.carservice.controller;

import com.app.carservice.entity.Car;
import com.app.carservice.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;
    @PostMapping("/save")
    public Mono<Car> saveCar(@RequestBody @Valid Car car) {
        return this.carService.saveCar(car);
    }

    @GetMapping("/{id}")
    public Mono<Car> findByIdCar(@PathVariable Integer id) {
        return this.carService.findByIdCar(id);
    }

    @GetMapping("/byUser/{userId}")
    public Mono<Car> findByIdUser(@PathVariable Integer userId) {
        return this.carService.findByUserId(userId);
    }

    @GetMapping()
    public Flux<Car> findAllCars() {
        return this.carService.findAllCars();
    }
}
