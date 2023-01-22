package ru.kata.pp_3_1_5_rest.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.pp_3_1_5_rest.model.Role;
import ru.kata.pp_3_1_5_rest.model.User;
import ru.kata.pp_3_1_5_rest.service.RoleService;
import ru.kata.pp_3_1_5_rest.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class Initializer {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public Initializer(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void init() {
        Role role1 = new Role(1L, "ROLE_ADMIN");
        Role role2 = new Role(2L, "ROLE_USER");

        roleService.save(role1);
        roleService.save(role2);

        User user1 = new User("ChegaZ", 26, "chegaz@mail.ru", "1996",
                new HashSet<>(Set.of(role1)));
        User user2 = new User("MongoDB", 28, "mongodb@mail.ru", "1996",
                new HashSet<>(Set.of(role2)));

        userService.save(user1);
        userService.save(user2);
    }
}