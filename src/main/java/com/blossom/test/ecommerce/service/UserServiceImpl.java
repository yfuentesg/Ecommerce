package com.blossom.test.ecommerce.service;

import com.blossom.test.ecommerce.database.model.User;
import com.blossom.test.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void addUser(User user) {
        if (!mailExists(user.getEmail())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        }
    }

    @Override
    public boolean mailExists(String email) {
        return userRepository.findByEmail(email) != null;
    }

    @Override
    public boolean isPasswordValid(User user, String passwordProvided) {
        if (user == null || passwordProvided == null || passwordProvided.isEmpty()) {
            return false;
        }
        return passwordEncoder.matches(passwordProvided, user.getPassword());
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
