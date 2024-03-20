package com.blossom.test.ecommerce.controller;

import com.blossom.test.ecommerce.database.model.User;
import com.blossom.test.ecommerce.dto.TokenDTO;
import com.blossom.test.ecommerce.security.JwtProvider;
import com.blossom.test.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody User user) {
        User ExistingUser = userService.getUserByEmail(user.getEmail());
        if (!userService.isPasswordValid(ExistingUser, user.getPassword())) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(jwtProvider.createToken(ExistingUser));
    }

    @PostMapping("/validate/{token}")
    public String validate(@PathVariable String token) {
        //jwtProvider.validate(token, );
        return "";
    }
}
