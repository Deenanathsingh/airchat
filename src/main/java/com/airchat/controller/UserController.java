package com.airchat.controller;

import com.airchat.entity.User;
import com.airchat.repository.UserJpaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserJpaRespository userJpaRepository;

    @GetMapping(value = "/all")
    public List<User> findAll(){
      return userJpaRepository.findAll();
    }
}
