package ru.kata.pp_3_1_5_rest.services;

import ru.kata.pp_3_1_5_rest.models.Role;

import java.util.List;

public interface RoleService {
    void saveRole(Role role);

    List<Role> getAllRoles();
}