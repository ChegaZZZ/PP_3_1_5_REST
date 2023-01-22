package ru.kata.pp_3_1_5_rest.service;

import ru.kata.pp_3_1_5_rest.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();

    User addUser(User user);

    User findUserById(Long id);

    void deleteUserById(Long id);

    User findUserByName(String name);

    void save(User user);
}