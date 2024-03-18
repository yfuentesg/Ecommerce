package com.blossom.test.ecommerce.controller;

import com.blossom.test.ecommerce.database.model.User;
import com.blossom.test.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping
    public boolean login(@RequestBody User user) {
        User ExistingUser = userService.getUserByEmail(user.getEmail());
        return userService.isPasswordValid(ExistingUser, user.getPassword());
    }
}
