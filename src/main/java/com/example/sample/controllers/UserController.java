package com.example.sample.controllers;

import com.example.sample.entities.User;
import com.example.sample.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/sample")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add/user")
    public @ResponseBody String addNewUser(@RequestParam String name) {
        User user = new User();
        user.setUser_name(name);
        userRepository.save(user);
        return "Saved";
    }

    @GetMapping(path = "/all/users")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
