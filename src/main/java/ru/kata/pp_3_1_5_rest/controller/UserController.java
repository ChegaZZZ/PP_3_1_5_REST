package ru.kata.pp_3_1_5_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.pp_3_1_5_rest.model.User;
import ru.kata.pp_3_1_5_rest.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUser(Model model, Principal principal) {
        User messages = userService.findUserByName(principal.getName());
        model.addAttribute("messages", messages);
        return "user";
    }
}