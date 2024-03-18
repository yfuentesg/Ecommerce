package com.blossom.test.ecommerce.service;

import com.blossom.test.ecommerce.database.model.User;

public interface UserService {
    public void addUser(User user);
    public boolean mailExists(String email);

    public boolean isPasswordValid(User user, String passwordProvided);
    public User getUserByEmail(String email);
}
