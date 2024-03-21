package com.blossom.test.ecommerce.controller;

import com.blossom.test.ecommerce.database.model.User;
import com.blossom.test.ecommerce.dto.TokenDTO;
import com.blossom.test.ecommerce.security.JwtProvider;
import com.blossom.test.ecommerce.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Api(tags = "Login Controller")
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/login")
    @ApiOperation("Generates a Token with 60 sg lifetime to use all endpoints")
    public ResponseEntity<TokenDTO> login(@RequestBody User user) {
        User ExistingUser = userService.getUserByEmail(user.getEmail());
        if (!userService.isPasswordValid(ExistingUser, user.getPassword())) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(jwtProvider.createToken(ExistingUser));
    }
}
