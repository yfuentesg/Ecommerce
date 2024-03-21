package com.blossom.test.ecommerce.controller;

import com.blossom.test.ecommerce.database.model.User;
import com.blossom.test.ecommerce.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Api(tags = "Users management Controller")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    @ApiOperation("Allows user creation")
    public void createUser(@RequestBody User user) {
        userService.addUser(user);
    }
}
