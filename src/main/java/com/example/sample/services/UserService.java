package com.example.sample.services;

import com.example.sample.entities.User;
import com.example.sample.repositories.UserRepository;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Mono<String> createUser(String name) {
        User user = new User();
        user.setUser_name(name);
        userRepository.save(user);
        if(log.isDebugEnabled()) {
            log.debug("name is saved");
        }
        return Mono.just("Saved");
    }

    public Mono<Iterable<User>> getAllUsers() {
        if(log.isDebugEnabled()) {
            log.debug("all users are printed");
        }
        return Mono.just(userRepository.findAll());
    }

}
