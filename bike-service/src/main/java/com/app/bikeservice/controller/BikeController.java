package com.app.bikeservice.controller;

import com.app.bikeservice.entity.Bike;
import com.app.bikeservice.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class BikeController {

    @Autowired
    private BikeService bikeService;

    @PostMapping("/save")
    public Mono<Bike> saveBike(@RequestBody @Valid Bike bike) {
        return this.bikeService.saveBike(bike);
    }

    @GetMapping("/{id}")
    public Mono<Bike> findByIdBike(@PathVariable Integer id) {
        return this.bikeService.findByIdBike(id);
    }

    @GetMapping("/byUser/{id}")
    public Mono<Bike> findByIdUser(@PathVariable Integer idUser) {
        return this.bikeService.findByIdUser(idUser);
    }

    @GetMapping()
    public Flux<Bike> findAllBikes() {
        return this.bikeService.findAllBikes();
    }
}
