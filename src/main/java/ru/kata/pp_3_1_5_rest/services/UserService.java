package ru.kata.pp_3_1_5_rest.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.pp_3_1_5_rest.models.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getAllUsers();

    User getUser(Long id);

    void saveUser(User user);

    void updateUser(User updatedUser);

    void deleteUser(Long id);

    User findByEmail(String email);
}