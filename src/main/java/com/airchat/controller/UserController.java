package com.airchat.controller;

import com.airchat.entity.User;
import com.airchat.repository.UserJpaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserJpaRespository userJpaRepository;

    @GetMapping(value = "/all")
    public Iterable<User> findAll() {
        return userJpaRepository.findAll();
    }

    @GetMapping("/")

    public String hello() {

        return "This is Home page";

    }


    @GetMapping("/saveuser")

    public String saveUser(@RequestParam String username, @RequestParam String firstname, @RequestParam String lastname, @RequestParam int age, @RequestParam String password) {

        User user = new User();

        userJpaRepository.saveMyUser(user);

        return "User Saved";
    }
}