package ru.kata.pp_3_1_5_rest.service;

import ru.kata.pp_3_1_5_rest.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRole();

    void save(Role role);
}