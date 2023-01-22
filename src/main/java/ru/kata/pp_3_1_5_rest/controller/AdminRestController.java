package ru.kata.pp_3_1_5_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kata.pp_3_1_5_rest.model.Role;
import ru.kata.pp_3_1_5_rest.model.User;
import ru.kata.pp_3_1_5_rest.service.RoleService;
import ru.kata.pp_3_1_5_rest.service.UserService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class AdminRestController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminRestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getAllRoles() {
        return new ResponseEntity<>(roleService.getAllRole(), HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<User> create(@RequestBody User user) {
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<User> getUser(Principal principal) {
        return new ResponseEntity<>(userService.findUserByName(principal.getName()), HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> editUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}