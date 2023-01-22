package ru.kata.pp_3_1_5_rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.pp_3_1_5_rest.model.Role;
import ru.kata.pp_3_1_5_rest.repository.RoleRepository;

import java.util.List;

@Service
public class RoleServiceInp implements RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceInp(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }

    @Override
    @Transactional
    public void save(Role role) {
        roleRepository.save(role);
    }
}