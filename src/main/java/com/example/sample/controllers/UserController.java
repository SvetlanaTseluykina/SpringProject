package com.example.sample.controllers;

import com.example.sample.entities.User;
import com.example.sample.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.security.Principal;

@RestController
@RequestMapping(path = "/sample")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(path = "/add/user")
    public Mono<String> addNewUser(String name) {
        return userService.createUser(name);
    }

    @GetMapping(path = "/all/users")
    public Mono<Iterable<User>> getAllUsers() {
        return userService.getAllUsers();
    }

//    @GetMapping(path = "/user")
//    public Mono<String> getUserByName() {
//        return userService.getUser();
//    }
}
