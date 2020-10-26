package com.airchat.repository;

import com.airchat.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserJpaRespository extends CrudRepository<User, Integer> {

    void saveMyUser(User user);

    Object showAllUsers();

    void deleteMyUser(int id);

    Object editUser(int id);

    public User findByUsernameAndPassword(String username, String password);

    void delete(int id);

    User findOne(int id);
}

