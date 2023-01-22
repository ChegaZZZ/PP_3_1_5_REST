package ru.kata.pp_3_1_5_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.pp_3_1_5_rest.model.User;
import ru.kata.pp_3_1_5_rest.service.RoleService;
import ru.kata.pp_3_1_5_rest.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String showAllUser(ModelMap model, Principal principal) {
        model.addAttribute("admin", userService.findUserByName(principal.getName()));
        model.addAttribute("people", userService.getAllUser());
        model.addAttribute("person", new User());
        model.addAttribute("roles", roleService.getAllRole());
        return "admin";
    }
}