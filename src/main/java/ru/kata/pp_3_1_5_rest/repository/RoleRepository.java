package ru.kata.pp_3_1_5_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kata.pp_3_1_5_rest.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}