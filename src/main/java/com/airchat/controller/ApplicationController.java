package com.airchat.controller;

import com.airchat.entity.User;
import com.airchat.repository.UserJpaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ApplicationController {


    @Autowired
    UserJpaRespository userJpaRespository;


    @RequestMapping("/welcome")

    public String Welcome(HttpServletRequest request) {

        request.setAttribute("mode", "MODE_HOME");

        return "welcomepage";

    }


    @RequestMapping("/register")

    public String registration(HttpServletRequest request) {

        request.setAttribute("mode", "MODE_REGISTER");

        return "welcomepage";

    }


    @PostMapping("/save-user")

    public String registerUser(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request) {

        userJpaRespository.saveMyUser(user);

        request.setAttribute("mode", "MODE_HOME");

        return "welcomepage";

    }


    @GetMapping("/show-users")

    public String showAllUsers(HttpServletRequest request) {

        request.setAttribute("users", userJpaRespository.showAllUsers());

        request.setAttribute("mode", "ALL_USERS");

        return "welcomepage";

    }


    @RequestMapping("/delete-user")

    public String deleteUser(@RequestParam int id, HttpServletRequest request) {

        userJpaRespository.deleteMyUser(id);

        request.setAttribute("users", userJpaRespository.showAllUsers());

        request.setAttribute("mode", "ALL_USERS");

        return "welcomepage";

    }


    @RequestMapping("/edit-user")

    public String editUser(@RequestParam int id, HttpServletRequest request) {

        request.setAttribute("user", userJpaRespository.editUser(id));

        request.setAttribute("mode", "MODE_UPDATE");

        return "welcomepage";

    }


    @RequestMapping("/login")

    public String login(HttpServletRequest request) {

        request.setAttribute("mode", "MODE_LOGIN");

        return "welcomepage";

    }


    @RequestMapping("/login-user")

    public String loginUser(@ModelAttribute User user, HttpServletRequest request) {

        if (userJpaRespository.findByUsernameAndPassword(user.getUsername(), user.getPassword()) != null) {

            return "homepage";

        } else {

            request.setAttribute("error", "Invalid Username or Password");

            request.setAttribute("mode", "MODE_LOGIN");

            return "welcomepage";


        }

    }


}
