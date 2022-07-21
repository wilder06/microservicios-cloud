package com.app.userservice.controller;

import com.app.userservice.dto.Car;
import com.app.userservice.entity.User;
import com.app.userservice.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public Mono<User> saveClient(@RequestBody @Valid User user) {
        return this.userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public Mono<User> findById(@PathVariable Integer id) {
        return this.userService.findByIdUser(id);
    }

    @GetMapping()
    public Flux<User> findAllClient() {
        return this.userService.findAllUsers();
    }
    @CircuitBreaker(name = "carsCB", fallbackMethod = "fallBackGetCars")
    @GetMapping("/cars/{idUser}")
    public Mono<Car> getCar(@PathVariable Integer idUser) {
        return this.userService.getCar(idUser);
    }
    private ResponseEntity fallBackGetCars(@PathVariable("userId") int userId, RuntimeException e) {
        return new ResponseEntity("El usuario " + userId + " tiene los coches en el taller", HttpStatus.OK);
    }
}
