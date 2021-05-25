package com.example.springmongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class MongoController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> users() {

       List<User> mongoList= userRepository.findAll();

        return mongoList;
    }

    @GetMapping("/new")
    public User addUser(){
        return userRepository.save(new User("Panchajanya"));
    }
}
