package com.app.bikeservice.service;

import com.app.bikeservice.entity.Bike;
import com.app.bikeservice.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BikeServiceImpl implements  BikeService{

    @Autowired
    private BikeRepository bikeRepository;
    @Override
    public Flux<Bike> findAllBikes() {
        return bikeRepository.findAll();
    }

    @Override
    public Mono<Bike> saveBike(Bike bike) {
        return bikeRepository.save(bike);
    }

    @Override
    public Mono<Bike> findByIdBike(Integer id) {
        return bikeRepository.findById(id);
    }

    @Override
    public Mono<Bike> findByIdUser(Integer idUser) {
        return bikeRepository.findByUserId(idUser);
    }
}
