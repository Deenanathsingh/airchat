package com.airchat.services;

import com.airchat.entity.User;
import com.airchat.repository.UserJpaRespository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService {


    private final UserJpaRespository userJpaRespository;


    public UserService(UserJpaRespository userJpaRespository) {

        this.userJpaRespository = userJpaRespository;

    }


    public void saveMyUser(User user) {

        userJpaRespository.save(user);

    }


    public List<User> showAllUsers() {

        List<User> users = new ArrayList<>();

        for (User user : userJpaRespository.findAll()) {

            users.add(user);

        }


        return users;

    }


    public void deleteMyUser(int id) {

        userJpaRespository.delete(id);

    }


    public User editUser(int id) {

        return userJpaRespository.findOne(id);

    }


    public User findByUsernameAndPassword(String username, String password) {

        return userJpaRespository.findByUsernameAndPassword(username, password);

    }


}




