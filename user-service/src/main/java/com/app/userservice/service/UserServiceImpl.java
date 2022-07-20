package com.app.userservice.service;

import com.app.userservice.dto.Car;
import com.app.userservice.entity.User;
import com.app.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WebClient.Builder client;

    @Override
    public Flux<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Mono<User> saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Mono<User> findByIdUser(Integer id) {
        return userRepository.findById(id);
    }

    public Mono<Car> getCar(Integer idUser) {
        return client.build().get()
                .uri("localhost:8030/api/{idUser}", idUser)
                .retrieve()
                .bodyToMono(Car.class);
        //2da Forma para ejecutar
        //.exchange()
        //.flatMap(response -> response.bodyToMono(Producto.class));
    }
}
