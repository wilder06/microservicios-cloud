package com.app.userservice.service;

import com.app.userservice.dto.Car;
import com.app.userservice.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Flux<User> findAllUsers();

    Mono<User> saveUser(User user);

    Mono<User> findByIdUser(Integer id);

    Mono<Car> getCar(Integer idUser);
}
